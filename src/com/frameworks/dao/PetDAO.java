package com.frameworks.dao;

import com.frameworks.model.Pessoa;
import com.frameworks.model.Pet;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PetDAO {

    private EntityManager em;

    public PetDAO(EntityManager entityManager){

        this.em = entityManager;
    }

    public void inserir(Pet pet){

        em.persist(pet);
    }

    public List<Pessoa> listar(){

        Query query = em.createQuery("select p from Pet p");

        return query.getResultList();
    }

    public List<Pet> listarPorNomeParcial(String nome){

        Query query = em.createQuery("select p from Pet p where p.nome like :parNome");

        query.setParameter("parNome", "%"+nome+"%");
        return query.getResultList();
    }

    public void remover(Integer id){

        Pet pet = em.find(Pet.class, id);

        em.remove(pet);
    }
}
