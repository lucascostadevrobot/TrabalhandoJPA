package org.example.connectionBD.executions;

import org.example.connectionBD.model.EnderecoPredial;
import org.example.connectionBD.model.Proprietarios;

import javax.persistence.*;
import javax.swing.*;
import java.util.List;
import java.util.Objects;

import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;

public class ExecutionJPQL {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mCODO");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    public static void main(String[] args) {
        cadastrandoProprietarios();

    }



    /**
     * Cadastrando Os Proprietarios e Endereços
     * */
    public static void cadastrandoProprietarios (){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mCODO");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        JTextField nomeField = new JTextField();
        JTextField idadeField = new JTextField();
        JCheckBox ativoBox = new JCheckBox("Ativo", false);

        JTextField ruaField = new JTextField();
        JTextField numeroField = new JTextField();
        JTextField bairroField = new JTextField();
        JTextField cidadeField = new JTextField();
        JTextField complementoField = new JTextField();
        JTextField numeroApartamentoField = new JTextField();


        Object[] formulario = {
                "Nome:", nomeField,
                "Idade:", idadeField,
                ativoBox,

                "Rua:",  ruaField,
                "Número:", numeroField,
                "Bairro", bairroField,
                "Cidade",cidadeField,
                "Complemento",complementoField,
                "Número do Apartamento", numeroApartamentoField

        };

        int opcao = JOptionPane.showConfirmDialog(null, formulario, "Deseja cadastrar o proprietario?", JOptionPane.OK_CANCEL_OPTION);

        if (opcao ==  JOptionPane.OK_OPTION){
            Proprietarios proprietarios = new Proprietarios();
            EnderecoPredial enderecoPredial = new EnderecoPredial();
            String nomeProprietario =   nomeField.getText();
            int idadeProprietario = Integer.parseInt(idadeField.getText());
            boolean isAtivo = Boolean.parseBoolean(ativoBox.getText());

            String ruaProprietario = ruaField.getText();
            int numeroEnderecoProprietario = Integer.parseInt(numeroField.getText());
            String bairroProprietario = bairroField.getText();
            String cidadeProprietario = cidadeField.getText();
            String complementoEnderecoProprietario = complementoField.getText();
            int numeroAptProprietario = Integer.parseInt(numeroApartamentoField.getText());



            entityManager.getTransaction().begin();

            proprietarios.setNome(nomeProprietario);
            proprietarios.setIdade(idadeProprietario);
            proprietarios.setAtivo(isAtivo);
            enderecoPredial.setRua(ruaProprietario);
            enderecoPredial.setNumero(numeroEnderecoProprietario);
            enderecoPredial.setBairro(bairroProprietario);
            enderecoPredial.setCidade(cidadeProprietario);
            enderecoPredial.setComplemento(complementoEnderecoProprietario);
            enderecoPredial.setNumeroApartamento(String.valueOf(numeroAptProprietario));


            entityManager.persist(proprietarios);
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null,"Proprietario cadastrado com sucesso!");

            entityManager.close();
            entityManagerFactory.close();

        }
    }

    /**
     * Lista Os Proprietarios e Endereços
     * */
    public static  void listandoProprietarios (){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mCODO");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String sqlListandoProprietarios = "SELECT a FROM Proprietarios a";
        List<Proprietarios> proprietariosListJpql = entityManager
                .createQuery(sqlListandoProprietarios, Proprietarios.class)
                .getResultList();

        JOptionPane.showMessageDialog(null, "Exibindo proprietarios: " + proprietariosListJpql);
    }
}
