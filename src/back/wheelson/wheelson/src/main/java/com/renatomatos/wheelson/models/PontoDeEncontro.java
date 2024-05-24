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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "PontoDeEncontro")
public class PontoDeEncontro{

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

   
    public PontoDeEncontro(Long id,String rua,  String bairro,
             String ponto_referencia) {
        this.id = id;
        this.rua = rua;
        this.bairro = bairro;
        this.ponto_referencia = ponto_referencia;
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
    
    
}
