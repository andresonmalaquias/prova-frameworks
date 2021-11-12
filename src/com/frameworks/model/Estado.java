package com.frameworks.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Estado {

    @Id
    @GeneratedValue
    private Integer id;

    private String codigoIBGE;

    private Pais pais;

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

    public Estado(String codigoIBGE, Pais pais) {
        this.codigoIBGE = codigoIBGE;
        this.pais = pais;
    }

    public Estado() {
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", codigoIBGE='" + codigoIBGE + '\'' +
                ", pais=" + pais +
                '}';
    }
}
