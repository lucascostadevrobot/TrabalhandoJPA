package org.example.connectionBD.model;

import javax.persistence.*;

@Entity
public class Proprietarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;
    @Column
    private Integer idade;
    @Column
    private boolean ativo;

    @Column
    @ManyToOne
    private EnderecoPredial enderecoPredial;

    public Proprietarios(Integer id, String nome, Integer idade, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.ativo = ativo;
    }

    public Proprietarios(EnderecoPredial enderecoPredial, String nome, Integer idade, boolean ativo) {
        this.enderecoPredial = enderecoPredial;
        this.nome = nome;
        this.idade = idade;
        this.ativo = ativo;
    }


    public Proprietarios() {
    }


    public EnderecoPredial getEnderecoPredial() {
        return enderecoPredial;
    }

    public void setEnderecoPredial(EnderecoPredial enderecoPredial) {
        this.enderecoPredial = enderecoPredial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Proprietarios{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", ativo=" + ativo +
                ", enderecoPredial=" + enderecoPredial +
                '}';
    }
}
