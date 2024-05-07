package com.renatomatos.wheelson.models;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carro")
    Long id;

    @Column(name = "marca", nullable = false, length = 20)
    String modelo;

    @Column(name = "modelo", nullable = false, length = 20)
    String ano;

    @Column(name = "valorDiario", nullable = false)
    double valorDiario;

    @Column(name = "crv", nullable = false, length = 11, unique = true)
    String crv;

    @Column(name = "placa", nullable = false, length = 7,unique = true)
    String placa;

    @Column(name = "disponivel", nullable = false)
    boolean disponivel;

    @ManyToOne
    @JoinColumn(name = "id_locador",nullable = false,updatable = false)
    Locador locador;

    public Carro() {
    }

    public Carro(String modelo, String ano, double valorDiario, String crv, String placa, boolean disponivel, Locador locador) {
        this.modelo = modelo;
        this.ano = ano;
        this.valorDiario = valorDiario;
        this.crv = crv;
        this.placa = placa;
        this.disponivel = disponivel;
        this.locador = locador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public double getValorDiario() {
        return valorDiario;
    }

    public void setValorDiario(double valorDiario) {
        this.valorDiario = valorDiario;
    }

    public String getCrv() {
        return crv;
    }

    public void setCrv(String crv) {
        this.crv = crv;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Locador getLocador() {
        return locador;
    }

    public void setLocador(Locador locador) {
        this.locador = locador;
    }

    
    
}
