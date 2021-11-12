package com.frameworks.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pais {
    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    private String CodigoISO;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoISO() {
        return CodigoISO;
    }

    public void setCodigoISO(String codigoISO) {
        CodigoISO = codigoISO;
    }

    public Pais() {
    }

    public Pais(String nome, String codigoISO) {
        this.nome = nome;
        CodigoISO = codigoISO;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", CodigoISO='" + CodigoISO + '\'' +
                '}';
    }
}
