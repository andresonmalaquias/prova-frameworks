package com.frameworks.dao;

import com.frameworks.model.Pais;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PaisDAO {

    private EntityManager em;

    public PaisDAO(EntityManager entityManager){

        this.em = entityManager;
    }

    public void inserir(Pais pais){

        em.persist(pais);
    }

    public List<Pais> listar(){

        Query query = em.createQuery("select p from Pais p");

        return query.getResultList();
    }

    public List<Pais> listarPorNomeParcial(String nome){

        Query query = em.createQuery("select p from Pais p where p.nome like :parNome");

        query.setParameter("parNome", "%"+nome+"%");
        return query.getResultList();
    }

    public void remover(Integer id){

        Pais pais = em.find(Pais.class, id);

        em.remove(pais);
    }
}
