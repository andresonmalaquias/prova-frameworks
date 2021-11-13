package com.frameworks.model;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
public class Pet {
    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    private SexoPetEnum sexo;

    private LocalDateTime nascimento;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Raca raca;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Pessoa proprietario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public SexoPetEnum getSexo() {
        return sexo;
    }

    public void setSexo(SexoPetEnum sexo) {
        this.sexo = sexo;
    }

    public LocalDateTime getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDateTime nascimento) {
        this.nascimento = nascimento;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
        raca.setPets(this);
    }

    public Pessoa getProprietario() {
        return proprietario;
    }

    public void setProprietario(Pessoa proprietario) {
        this.proprietario = proprietario;
    }

    public Pet(String nome, SexoPetEnum sexo, LocalDateTime nascimento, Raca raca, Pessoa proprietario) {
        this.nome = nome;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.raca = raca;
        this.proprietario = proprietario;
    }

    public Pet() {
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sexo=" + sexo +
                ", nascimento=" + nascimento +
                ", raca=" + raca +
                ", proprietario=" + proprietario +
                '}';
    }
}
