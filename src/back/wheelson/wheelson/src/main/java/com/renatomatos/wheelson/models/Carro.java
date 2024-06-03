package com.renatomatos.wheelson.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carro")
    Long id_carro;

    @NotBlank
    @Column(name = "modelo", nullable = false, length = 20)
    String modelo;

    @NotBlank
    @Column(name = "marca", nullable = false, length = 20)
    String marca;

    @NotBlank
    @Column(name = "ano", nullable = false, length = 4)
    String ano;

    @Column(name = "valorDiario", nullable = false)
    double valorDiario;

    @NotEmpty
    @NotNull
    @Column(name = "renavam", nullable = false, length = 11, unique = true)
    String renavam;

    @NotEmpty
    @NotNull
    @Column(name = "placa", nullable = false, length = 7, unique = true)
    String placa;

    @Column(name = "disponivel", nullable = false)
    boolean disponivel;

    @ManyToOne
    @JoinColumn(name = "id_locador", nullable = false, updatable = false)
    Locador locador;

    @OneToMany(mappedBy = "carro")
    List<PontoDeEncontro> pontoDeEncontro;

    // Getters and setters
    public Long getId() {
        return id_carro;
    }

    public void setId(Long id_carro) {
        this.id_carro = id_carro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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
    @JsonIgnore
    public List<PontoDeEncontro> getPontoDeEncontro() {
        return pontoDeEncontro;
    }

    public void setPontoDeEncontro(List<PontoDeEncontro> pontoDeEncontro) {
        this.pontoDeEncontro = pontoDeEncontro;
    }
}
