package com.frameworks.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cidade {

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    private String codigoIBGE;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Estado estado;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "cidade")
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

    public void setPessoa(Pessoa pessoa) {
        if(!this.pessoas.contains(pessoa)){
            this.pessoas.add(pessoa);
            pessoa.setCidade(this);
        }
    }

    public Cidade(String nome, String codigoIBGE, Estado estado, Pessoa pessoa) {
        this.nome = nome;
        this.codigoIBGE = codigoIBGE;
        this.estado = estado;
        this.pessoas = new ArrayList<>();
        this.pessoas.add(pessoa);
    }

    public Cidade(String nome, String codigoIBGE, Estado estado) {
        this.nome = nome;
        this.codigoIBGE = codigoIBGE;
        this.estado = estado;
        this.pessoas = new ArrayList<>();
    }


    public Cidade() {
        this.pessoas = new ArrayList<>();
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
