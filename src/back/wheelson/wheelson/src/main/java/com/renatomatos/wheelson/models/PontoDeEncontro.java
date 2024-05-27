package com.renatomatos.wheelson.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "PontoDeEncontro")
public class PontoDeEncontro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @NotEmpty
    @NotNull
    @Column(name = "rua", nullable = false, length = 20)
    String rua;

    @NotEmpty
    @NotNull
    @Column(name = "bairro", nullable = false, length = 20)
    String bairro;

    @NotEmpty
    @NotNull
    @Column(name = "ponto_referencia", nullable = true, length = 20)
    String ponto_referencia;

    @OneToOne
    @JoinColumn(name = "id_carro", nullable = false)
    Carro carro;

    // Construtores, getters e setters
    public PontoDeEncontro(Long id, String rua, String bairro, String ponto_referencia, Carro carro) {
        this.id = id;
        this.rua = rua;
        this.bairro = bairro;
        this.ponto_referencia = ponto_referencia;
        this.carro = carro;
    }

    public PontoDeEncontro() {
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getPonto_referencia() {
        return ponto_referencia;
    }

    public void setPonto_referencia(String ponto_referencia) {
        this.ponto_referencia = ponto_referencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
@JsonIgnore
    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
