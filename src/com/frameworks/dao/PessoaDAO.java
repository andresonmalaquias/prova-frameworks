package com.frameworks.dao;

import com.frameworks.model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PessoaDAO {

    private EntityManager em;

    public PessoaDAO(EntityManager entityManager){

        this.em = entityManager;
    }

    public void inserir(Pessoa pessoa){

        em.persist(pessoa);
    }

    public List<Pessoa> listar(){

        Query query = em.createQuery("select p from Pessoa p");

        return query.getResultList();
    }

    public List<Pessoa> listarPorNomeParcial(String nome){

        Query query = em.createQuery("select p from Pessoa p where p.nome like :parNome");

        query.setParameter("parNome", "%"+nome+"%");
        return query.getResultList();
    }

    public void remover(Integer id){

        Pessoa pessoa = em.find(Pessoa.class, id);

        em.remove(pessoa);
    }
}
