package com.frameworks.dao;

import com.frameworks.model.Especie;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EspecieDAO {

    private EntityManager em;

    public EspecieDAO(EntityManager entityManager){

        this.em = entityManager;
    }

    public void inserir(Especie especie){

        em.persist(especie);
    }

    public List<Especie> listar(){

        Query query = em.createQuery("select e from Especie e");

        return query.getResultList();
    }

    public List<Especie> listarPorNomeParcial(String nome){

        Query query = em.createQuery("select e from Estado e where e.nome like :parNome");

        query.setParameter("parNome", "%"+nome+"%");
        return query.getResultList();
    }

    public void remover(Integer id){

        Especie especie = em.find(Especie.class, id);

        em.remove(especie);
    }
}