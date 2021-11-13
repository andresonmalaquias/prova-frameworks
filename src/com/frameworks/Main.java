package com.frameworks;

import com.frameworks.dao.*;
import com.frameworks.model.*;
import com.frameworks.util.JPAUtil;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void CriarNovosDados() {
        Pais paisBr = new Pais("Brasil", "BR");
        Pais paisEua = new Pais("Estados Unidos da America", "EUA");

        Estado estadoAm = new Estado("Amazonas", "AM", paisBr);
        Estado estadoSP = new Estado("São Paulo", "SP", paisBr);

        Estado estadoNy = new Estado("Nova York", "NY", paisEua);
        Estado estadoCa = new Estado("Califórnia", "CA", paisEua);

        Cidade cidadeMa = new Cidade("Manaus", "035", estadoAm);
        Cidade cidadeMan = new Cidade("Manaquiri", "036", estadoAm);

        Pessoa pessoa1 = new Pessoa("José", "12345", "9299999999", "jose@gmail.com",
                LocalDateTime.of(1998, 10, 1, 0, 0),
                "Rua da Paz", cidadeMa, PessoaENUM.PROPRIETARIO, SexoPessoaENUM.MASCULINO);

        Pessoa pessoa2 = new Pessoa("Maria", "54321", "9299999998", "maria@gmail.com",
                LocalDateTime.of(1996, 7, 14, 0, 0),
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

        Pet pet1 = new Pet("Puguinha", SexoPetEnum.MACHO, LocalDateTime.of(2021, 11, 10, 0, 0),
                raca8, pessoa2);
        Pet pet2 = new Pet("Carrapatinha", SexoPetEnum.FEMEA, LocalDateTime.of(2021, 11, 10, 0, 0),
                raca8, pessoa2);

        Pet pet3 = new Pet("Emerson", SexoPetEnum.MACHO, LocalDateTime.of(2011, 5, 25, 0, 0),
                raca11, pessoa1);

        EntityManager em = JPAUtil.getEntityManager();

        PetDAO petDAO = new PetDAO(em);
        em.getTransaction().begin();

        petDAO.inserir(pet1);
        petDAO.inserir(pet2);
        petDAO.inserir(pet3);



        RacaDAO racaDAO = new RacaDAO(em);

        racaDAO.inserir(raca1);
        racaDAO.inserir(raca2);
        racaDAO.inserir(raca3);
        racaDAO.inserir(raca4);
        racaDAO.inserir(raca5);
        racaDAO.inserir(raca6);
        racaDAO.inserir(raca7);
        racaDAO.inserir(raca9);
        racaDAO.inserir(raca10);
        racaDAO.inserir(raca12);


        CidadeDAO cidadeDAO = new CidadeDAO(em);


        cidadeDAO.inserir(cidadeMan);


        EstadoDAO estadoDAO = new EstadoDAO(em);

        estadoDAO.inserir(estadoCa);
        estadoDAO.inserir(estadoNy);
        estadoDAO.inserir(estadoSP);

        em.getTransaction().commit();
        em.close();
    }

    public static void CriarPessoaComCidadeExistente() {
        EntityManager em = JPAUtil.getEntityManager();
        String nome = "Manaus";
        List<Cidade> cidades;

        em.getTransaction().begin();
        CidadeDAO cidadeDAO = new CidadeDAO(em);
        PessoaDAO pessoaDAO = new PessoaDAO(em);

        cidades = cidadeDAO.listarPorNomeParcial(nome);

        /*for (Cidade c: cidades) {
            System.out.println(c);
        }*/



        Pessoa p = new Pessoa();

        p.setNome("Mario");
        p.setDocumento("0123456");
        p.setEmail("mario@gmail.com");
        p.setNascimento(LocalDateTime.of(2000, 01, 11, 0, 0));
        p.setEndereco("Rua A");
        p.setSexo(SexoPessoaENUM.MASCULINO);
        p.setTelefone("92991010101");
        p.setTipo(PessoaENUM.PROPRIETARIO);
        p.setCidade(cidades.get(0));

        pessoaDAO.inserir(p);

        em.getTransaction().commit();
        em.close();

    }

    public static void CriarPetComRacaExistente() {
        EntityManager em = JPAUtil.getEntityManager();
        String nomeRaca = "Chihuahua";
        String nome = "Mario";
        List<Raca> racas;
        List<Pessoa> pessoas;

        RacaDAO racaDAO = new RacaDAO(em);
        PessoaDAO pessoaDAO = new PessoaDAO(em);
        PetDAO petDAO = new PetDAO(em);

        em.getTransaction().begin();

        racas = racaDAO.listarPorNomeParcial(nomeRaca);
        pessoas = pessoaDAO.listarPorNomeParcial(nome);

        System.out.println(racas);

        Pet pet = new Pet("Doguinha", SexoPetEnum.FEMEA,
                LocalDateTime.of(2010, 02, 1, 0, 0), racas.get(0),
                pessoas.get(0));

        petDAO.inserir(pet);
        em.getTransaction().commit();
        em.close();
    }

    public static void consultarPessoas(){
        EntityManager em = JPAUtil.getEntityManager();

        PessoaDAO pessoaDAO = new PessoaDAO(em);


        for (Pessoa p : pessoaDAO.listar()) {
            System.out.println(p.getNome());
        }

        em.close();
    }

    public static void consultarPets(){
        EntityManager em = JPAUtil.getEntityManager();

        PetDAO petDAO = new PetDAO(em);


        for (Pet p : petDAO.listar()) {
            System.out.println(p.getNome());
        }

        em.close();
    }

    public static void main(String[] args) {


        //CriarNovosDados();
        //CriarPessoaComCidadeExistente();
        //CriarPetComRacaExistente();
        //consultarPessoas();
        consultarPets();


    }
}
