package com.frameworks.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Raca {
    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Especie especie;

    @OneToMany(cascade = CascadeType.PERSIST)
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

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "raca")
    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(Pet pet) {
        if(this.pets.contains(pet)){
            this.pets.add(pet);
            pet.setRaca(this);
        }
    }

    public Raca(String nome, Especie especie, Pet pet) {
        this.nome = nome;
        this.especie = especie;
        this.pets = new ArrayList<>();
        this.pets.add(pet);
    }

    public Raca(String nome, Especie especie) {
        this.nome = nome;
        this.especie = especie;
        this.pets = new ArrayList<>();
    }

    public Raca() {
        this.pets = new ArrayList<>();
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
