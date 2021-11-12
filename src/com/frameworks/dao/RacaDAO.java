package com.frameworks.dao;

import com.frameworks.model.Raca;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class RacaDAO {

    private EntityManager em;

    public RacaDAO(EntityManager entityManager){

        this.em = entityManager;
    }

    public void inserir(Raca raca){

        em.persist(raca);
    }

    public List<Raca> listar(){

        Query query = em.createQuery("select r from Raca r");

        return query.getResultList();
    }

    public List<Raca> listarPorNomeParcial(String nome){

        Query query = em.createQuery("select r from Raca r where r.nome like :parNome");

        query.setParameter("parNome", "%"+nome+"%");
        return query.getResultList();
    }

    public void remover(Integer id){

        Raca raca = em.find(Raca.class, id);

        em.remove(raca);
    }
}
