package com.frameworks.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Especie {
    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especie(String nome) {
        this.nome = nome;
    }

    public Especie() {
    }
}
