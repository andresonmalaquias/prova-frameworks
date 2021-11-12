package com.frameworks.model;

import java.util.List;
import javax.persistence.*;

@Entity
public class Raca {
    @Id
    @GeneratedValue
    private Integer id;

    private String nome;
    private Especie especie;
    private List<Pet> pets;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public Raca(String nome, Especie especie, List<Pet> pets) {
        this.nome = nome;
        this.especie = especie;
        this.pets = pets;
    }

    public Raca() {
    }

    @Override
    public String toString() {
        return "Raca{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", especie=" + especie +
                ", pets=" + pets +
                '}';
    }
}
