package com.atividadeLoja.atividadeLoja.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa {
    @Column(name = "cpf", nullable = true)
    private String cpf;
    @Column(name = "rg", nullable = true)
    private String rg;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String getDocumentoPrincipal() {
        return this.getCpf();
    }

}
