package com.frameworks.dao;

import com.frameworks.model.Cidade;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CidadeDAO {

    private EntityManager em;

    public CidadeDAO(EntityManager entityManager){

        this.em = entityManager;
    }

    public void inserir(Cidade cidade){

        em.persist(cidade);
    }

    public List<Cidade> listar(){

        Query query = em.createQuery("select c from Cidade c");

        return query.getResultList();
    }

    public List<Cidade> listarPorNomeParcial(String nome){

        Query query = em.createQuery("select c from Cidade c where c.nome like :parNome");

        query.setParameter("parNome", "%"+nome+"%");
        return query.getResultList();
    }

    public void remover(Integer id){

        Cidade cidade = em.find(Cidade.class, id);

        em.remove(cidade);
    }
}
