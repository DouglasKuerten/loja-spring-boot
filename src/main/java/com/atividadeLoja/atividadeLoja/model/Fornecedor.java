package com.atividadeLoja.atividadeLoja.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Fornecedor extends Pessoa {
    @Column(name = "cnpj", nullable = true)
    private String cnpj;
    @Column(name = "inscricao_estadual", nullable = true)
    private String inscricaoEstadual;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    @Override
    public String getDocumentoPrincipal() {
        return this.getCnpj();
    }

}
