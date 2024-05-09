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
    @Column(name = "idCarro")
    Long idCarro;

    @Column(name = "modelo", nullable = false, length = 20)
    String modelo;

    @Column(name = "marca", nullable = false, length = 20)
    String marca;

    @Column(name = "ano", nullable = false, length = 4)
    String ano;

    @Column(name = "valorDiario", nullable = false)
    double valorDiario;

    @Column(name = "renavam", nullable = false, length = 11, unique = true)
    String renavam;

    @Column(name = "placa", nullable = false, length = 7,unique = true)
    String placa;

    @Column(name = "disponivel", nullable = false)
    boolean disponivel;

    @ManyToOne
    @JoinColumn(name = "id",nullable = false,updatable = false)
    Locador locador;

    public Carro() {
    }

    public Carro(String modelo, String ano, double valorDiario, String renavam, String placa, boolean disponivel, Locador locador) {
        this.modelo = modelo;
        this.ano = ano;
        this.valorDiario = valorDiario;
        this.renavam = renavam;
        this.placa = placa;
        this.disponivel = disponivel;
        this.locador = locador;
    }

    public Long getId() {
        return idCarro;
    }

    public void setId(Long idCarro) {
        this.idCarro = idCarro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getMarca(){
        return marca;
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

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
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
