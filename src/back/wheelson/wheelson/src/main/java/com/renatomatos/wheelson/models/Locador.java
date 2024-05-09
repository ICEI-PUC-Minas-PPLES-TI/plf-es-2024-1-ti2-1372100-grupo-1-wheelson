package com.renatomatos.wheelson.models;
/*
 * import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
*/

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;



//novos imports
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;


@Entity
@Table(name = "Locador")
public class Locador {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "nome", nullable = false, unique = true, length = 100)
    String nome;
    //Com o tamanho de 14, pois o cpf tem 11 digitos e 3 pontos
    @Column(name = "cpf", nullable = false, unique = true,  length = 14)
    String cpf;

    @Column(name = "data_nascimento", nullable = false, length = 10)
    String data_nascimento;

    @Column(name = "email", nullable = false, unique = true, length = 35)
    String email;

    @Column(name = "telefone", nullable = false,length =  14)
    String telefone;

    @Column(name = "rua", nullable = false, length = 50)
    String rua;

    @Column(name = "bairro", nullable = false, length = 20)
    String bairro;

    @Column(name = "numero_resid", nullable = false, length = 5)
    String numero_resid;

    @Column(name = "cidade", nullable = false, length =15)
    String cidade;

    
    @Column(name = "uf",nullable = false, length = 2)
    String uf;

    //Aprovado no sistema ou nao, deve ser inicializado como false sempre
    @Column(name = "status", nullable = false ) //, columnDefinition = "boolean default false" 
    boolean status;

    //Valor gerado após o aluguel concluido, deve semore começar com 0
    @Column(name = "saldo", nullable = false)//, columnDefinition = "float default 0"
    float saldo;

    //Na hora que for cadastrado, deve puxar a data atual e colocar neste campo
    @Column(name = "data_entrada", nullable = false) //, columnDefinition = "date default current_date"
    Date data_entrada;

    @Column(name = "senha", nullable = false)
    String senha;

    // Mapped by funciona pelo nome da variavel em Carro.
    @OneToMany(mappedBy = "locador")
    private List<Carro> carros = new ArrayList<Carro>();


    
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCpf() {
        return cpf;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getData_nascimento() {
        return data_nascimento;
    }


    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getTelefone() {
        return telefone;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
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


    public String getNumero_resid() {
        return numero_resid;
    }


    public void setNumero_resid(String numero_resid) {
        this.numero_resid = numero_resid;
    }


    public String getCidade() {
        return cidade;
    }


    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public String getuf() {
        return uf;
    }


    public void setuf(String uf) {
        this.uf = uf;
    }
    


    public boolean getStatus() {
        return status;
    }


    public void setStatus(boolean status) {
        this.status = status;
    }


    public float getSaldo() {
        return saldo;
    }


    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }


    public Date getData_entrada() {
        return data_entrada;
    }


    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }


    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }


}
