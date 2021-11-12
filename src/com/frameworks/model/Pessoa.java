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

}
