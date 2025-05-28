package org.example.connectionBD;

import org.example.connectionBD.model.EnderecoPredial;
import org.example.connectionBD.model.Proprietarios;

import javax.persistence.*;
import java.util.List;

public class ExecutionPersistence {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("meu-condominio-test");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Instanciando novos objetos nas para entidades
        EnderecoPredial enderecoPredialAdicionados = new EnderecoPredial("Rua Andalessa Antonio de Oliveira", 90, "Cidade Nova", "Baixo Fundos", "Italva", "202");
        Proprietarios proprietariosAdicionados = new Proprietarios(enderecoPredialAdicionados, "Eva Maria da Costa Pinto Silva", 75, true);

        //Inicaliza a instancia para persistir a transação no Banco de Dados
        entityManager.getTransaction().begin();

        entityManager.persist(enderecoPredialAdicionados);
        entityManager.persist(proprietariosAdicionados);


        //Faz o commit para o Banco de Dados após as transações
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
