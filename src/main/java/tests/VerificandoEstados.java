package tests;

import models.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VerificandoEstados {
    public static void test() {
        Conta conta = new Conta();

        conta.setTitular("Almiro");
        conta.setAgencia(123);
        conta.setNumero(321);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // transient -> managed
        entityManager.persist(conta);

        // managed -> removed
        entityManager.remove(conta);

        // entityManager.getTransaction().commit();
        entityManager.close();
    }
}