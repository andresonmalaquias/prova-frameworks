package com.frameworks.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cidade {

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    private String codigoIBGE;

    @ManyToOne
    private Estado estado;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private List<Pessoa> pessoas;

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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Cidade(String nome, String codigoIBGE, Estado estado, List<Pessoa> pessoas) {
        this.nome = nome;
        this.codigoIBGE = codigoIBGE;
        this.estado = estado;
        this.pessoas = pessoas;
    }

    public Cidade() {
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", codigoIBGE='" + codigoIBGE + '\'' +
                ", estado=" + estado +
                ", pessoas=" + pessoas +
                '}';
    }
}
