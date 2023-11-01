package com.atividadeLoja.atividadeLoja.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_item")
public abstract class ItemVendavel extends EntityId {
    @Column(name = "descricao", nullable = true)
    private String descricao;
    @Column(name = "valor_unitario", nullable = true)
    private Double valorUnitario;
    @Column(name = "estocavel", nullable = true)
    private Boolean estocavel;

    public Boolean getEstocavel() {
        return estocavel;
    }

    public void setEstocavel(Boolean estocavel) {
        this.estocavel = estocavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public String toString() {
        return "ItemVendavel{" +
                "descricao='" + descricao + '\'' +
                ", valorUnitario=" + valorUnitario +
                ", estocavel=" + estocavel +
                '}';
    }
}
