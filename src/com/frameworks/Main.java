package com.frameworks;

import com.frameworks.dao.PessoaDAO;
import com.frameworks.dao.PetDAO;
import com.frameworks.model.*;
import com.frameworks.util.JPAUtil;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

public class Main {

    public static void CriarNovosDados(){
        Pais paisBr = new Pais("Brasil", "BR");
        Pais paisEua = new Pais("Portugal", "EUA");

        Estado estadoAm = new Estado("Amazonas", "AM", paisBr);
        Estado estadoSP = new Estado("São Paulo", "SP", paisBr);

        Estado estadoNy = new Estado("Nova York", "NY", paisEua);
        Estado estadoCa = new Estado("Califórnia", "CA", paisEua);

        Cidade cidadeMa =  new Cidade("Manaus", "035", estadoAm);
        Cidade cidadeMan =  new Cidade("Manaquiri", "036", estadoAm);

        Pessoa pessoa1 = new Pessoa("José", "12345", "9299999999", "jose@gmail.com",
                LocalDateTime.of(1998, 10, 1,0,0),
                "Rua da Paz", cidadeMa, PessoaENUM.PROPRIETARIO, SexoPessoaENUM.MASCULINO);

        Pessoa pessoa2 = new Pessoa("Maria", "54321", "9299999998", "maria@gmail.com",
                LocalDateTime.of(1996, 7, 14,0,0),
                "Rua A", cidadeMa, PessoaENUM.PROPRIETARIO, SexoPessoaENUM.FEMININO);

        Especie especie1 = new Especie("Felino");
        Especie especie2 = new Especie("Canina");
        Especie especie3 = new Especie("Repteis");

        Raca raca1 = new Raca("Persa", especie1);
        Raca raca2 = new Raca("Maine Coon", especie1);
        Raca raca3 = new Raca("Gato-de-bengala", especie1);
        Raca raca4 = new Raca("Gato Savannah", especie1);

        Raca raca5 = new Raca("Caramelo", especie2);
        Raca raca6 = new Raca("Yorkshire", especie2);
        Raca raca7 = new Raca("Pastor Alemão", especie2);
        Raca raca8 = new Raca("Chihuahua", especie2);

        Raca raca9 = new Raca("Iguana verde", especie3);
        Raca raca10 = new Raca("Jabuti-tiga", especie3);
        Raca raca11 = new Raca("Teiú", especie3);
        Raca raca12 = new Raca("Jiboia arco-íris da Amazônia", especie3);

        Pet pet1 = new Pet("Puguinha", SexoPetEnum.MACHO, LocalDateTime.of(2021, 11, 10,0,0),
                raca8, pessoa2);
        Pet pet2 = new Pet("Carrapatinha", SexoPetEnum.FEMEA, LocalDateTime.of(2021, 11, 10,0,0),
                raca8, pessoa2);

        Pet pet3 = new Pet("Emerson", SexoPetEnum.MACHO, LocalDateTime.of(2011, 5, 25,0,0),
                raca11, pessoa1);

        EntityManager em = JPAUtil.getEntityManager();

        PetDAO petDAO = new PetDAO(em);


        em.getTransaction().begin();


       petDAO.inserir(pet1);
        petDAO.inserir(pet2);
        petDAO.inserir(pet3);

        /*em.persist(paisBr);

        em.persist(estadoAm);

        em.persist(cidadeMa);

        em.persist(pessoa1);

        em.persist(especie3);

        em.persist(raca11);

        em.persist(pet3);*/


        em.getTransaction().commit();
        em.close();

    }

    public static void CriarPessoaComCidadeExistente(){


    }

    public static void criarPetComRacaExistente(){


    }

    public static void main(String[] args) {

        //CriarNovosDados();


    }
}
