package org.example.connectionBD.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class EnderecoPredial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEndereco;

    @Column
    private String rua;
    @Column
    private Integer numero;
    @Column
    private String bairro;
    @Column
    private String cidade;
    @Column
    private String complemento;
    @Column
    private String numeroApartamento;
    @OneToMany
    private List<Proprietarios> proprietariosList;

    public EnderecoPredial(Integer idEndereco, String rua, Integer numero, String bairro, String complemento, String cidade, String numeroApartamento) {
        this.idEndereco = idEndereco;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.numeroApartamento = numeroApartamento;
    }

    public EnderecoPredial(String rua, Integer numero, String bairro, String complemento, String cidade, String numeroApartamento) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.numeroApartamento = numeroApartamento;
    }

    public EnderecoPredial() {
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumeroApartamento() {
        return numeroApartamento;
    }

    public void setNumeroApartamento(String numeroApartamento) {
        this.numeroApartamento = numeroApartamento;
    }

    @Override
    public String toString() {
        return "EnderecoPredial{" +
                "idEndereco=" + idEndereco +
                ", rua='" + rua + '\'' +
                ", numero=" + numero +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", complemento='" + complemento + '\'' +
                ", numeroApartamento='" + numeroApartamento + '\'' +
                '}';
    }
}
