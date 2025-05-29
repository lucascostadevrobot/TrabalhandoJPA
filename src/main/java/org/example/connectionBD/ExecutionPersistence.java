package org.example.connectionBD;


import org.example.connectionBD.model.EnderecoPredial;
import org.example.connectionBD.model.Proprietarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;


public class ExecutionPersistence {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mCODO");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        /**
         * Cadastro de Proprietarios e Endereços
         * */
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


        /**
         * Lista Os Proprietarios e Endereços
         * */
        Proprietarios exibindoProprietarios = entityManager.find(Proprietarios.class, 1);

        if (exibindoProprietarios == null) {
            JOptionPane.showMessageDialog(null, "Nenhum proprietário encontrado no sistema.");
        } else {
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Exibindo proprietarios:  " + exibindoProprietarios);
        }

        entityManager.close();
        entityManagerFactory.close();


        /**
         * Deleta Proprietarios
         * */
        entityManager.getTransaction().begin();
        Proprietarios proprietarioEncontrado = entityManager.find(Proprietarios.class, 2);
        if (proprietarioEncontrado == null) {
            JOptionPane.showMessageDialog(null, "Nenhum proprietario foi encontrado, tente novamente");
        } else {
            entityManager.remove(proprietarioEncontrado);
            JOptionPane.showMessageDialog(null, "O proprietario foi excluido com sucesso.   " + proprietarioEncontrado.getNome());
            entityManager.getTransaction().commit();
        }

        entityManager.close();
        entityManagerFactory.close();

        /**
         * Altera Proprietarios
         * */
        entityManager.getTransaction().begin();
        Proprietarios proprietarioAlterado = entityManager.find(Proprietarios.class, 1);
        proprietarioAlterado.setNome("Eva Maria");
        JOptionPane.showMessageDialog(null, "O proprietario foi alterado.   " + proprietarioAlterado);


        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
