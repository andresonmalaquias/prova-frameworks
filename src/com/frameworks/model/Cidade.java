package com.frameworks.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Cidade {

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    private String codigoIBGE;

    private Estado estado;

    private List<Pessoa> pessoas;
}
