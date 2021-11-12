package com.frameworks.dao;


import com.frameworks.model.Estado;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EstadoDAO {

    private EntityManager em;

    public EstadoDAO(EntityManager entityManager){

        this.em = entityManager;
    }

    public void inserir(Estado estado){

        em.persist(estado);
    }

    public List<Estado> listar(){

        Query query = em.createQuery("select e from Estado e");

        return query.getResultList();
    }

    public List<Estado> listarPorNomeParcial(String nome){

        Query query = em.createQuery("select e from Estado e where e.nome like :parNome");

        query.setParameter("parNome", "%"+nome+"%");
        return query.getResultList();
    }

    public void remover(Integer id){

        Estado estado = em.find(Estado.class, id);

        em.remove(estado);
    }
}
