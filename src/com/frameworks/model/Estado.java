package com.frameworks.model;

import javax.persistence.*;

@Entity
public class Estado {

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    private String codigoIBGE;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Pais pais;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoIBGE() {
        return codigoIBGE;
    }

    public void setCodigoIBGE(String codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Estado(String nome, String codigoIBGE, Pais pais) {
        this.nome = nome;
        this.codigoIBGE = codigoIBGE;
        this.pais = pais;
    }

    public Estado() {
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", codigoIBGE='" + codigoIBGE + '\'' +
                ", pais=" + pais +
                '}';
    }
}
