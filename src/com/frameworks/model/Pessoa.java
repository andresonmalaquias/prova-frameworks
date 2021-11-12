package com.frameworks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String documento;

    private String telefone;

    private String email;

    private LocalDateTime nascimento;

    private String endereco;

    private Cidade cidade;

    private PessoaENUM tipo;

    private SexoPessoaENUM sexo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDateTime nascimento) {
        this.nascimento = nascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public PessoaENUM getTipo() {
        return tipo;
    }

    public void setTipo(PessoaENUM tipo) {
        this.tipo = tipo;
    }

    public SexoPessoaENUM getSexo() {
        return sexo;
    }

    public void setSexo(SexoPessoaENUM sexo) {
        this.sexo = sexo;
    }

    public Pessoa(String nome, String documento, String telefone, String email, LocalDateTime nascimento, String endereco, Cidade cidade, PessoaENUM tipo, SexoPessoaENUM sexo) {
        this.nome = nome;
        this.documento = documento;
        this.telefone = telefone;
        this.email = email;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.cidade = cidade;
        this.tipo = tipo;
        this.sexo = sexo;
    }

    public Pessoa() {
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", nascimento=" + nascimento +
                ", endereco='" + endereco + '\'' +
                ", cidade=" + cidade +
                ", tipo=" + tipo +
                ", sexo=" + sexo +
                '}';
    }
}
