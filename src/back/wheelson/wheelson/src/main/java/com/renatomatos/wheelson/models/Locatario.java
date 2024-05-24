package com.renatomatos.wheelson.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

@Entity
@Table(name ="Locatario")
public class Locatario {
    @Id
    @Column(name = "id_locatario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_locatario;

    @NotEmpty
    @NotNull
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "data_nascimento", nullable = false)
    private String dataNascimento;

    @Column(name = "email", nullable = false, unique = true, length = 35)
    String email;

    @Column(name = "telefone", nullable = false,length =  14)
    String telefone;

    @Column(name = "rua", nullable = false, length = 50)
    String rua;

    @Column(name = "bairro", nullable = false, length = 20)
    String bairro;

    @Column(name = "numero_resid_Locatario",  length = 5)
    String numero_resid_Locatario;

    @Column(name = "cidade", nullable = false, length =15)
    String cidade;

    
    @Column(name = "uf", length = 2)
    String uf;

    //Aprovado no sistema ou nao, deve ser inicializado como false sempre
    @Column(name = "status", nullable = false ) //, columnDefinition = "boolean default false" 
    boolean status;
    
    // @Lob
    // @Column(name = "imagem_cnh")
    // private byte[] imagemCNH;

    @Column(name = "cnh", nullable = false, length = 11, unique = true)
    private String cnh;

    @Column(name = "data_entrada")
    private Date data_entrada;

    @Column(name = "senha", nullable = false)
    private String senha;

    public Long getId() {
        return id_locatario;
    }

    public void setId(Long id_locatario) {
        this.id_locatario = id_locatario;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public String getNumeroResid() {
        return numero_resid_Locatario;
    }

    public void setNumeroResid(String numero_resid_Locatario) {
        this.numero_resid_Locatario = numero_resid_Locatario;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUF() {
        return uf;
    }

    public void setUF(String uF) {
        uf = uF;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // public byte[] getImagemCNH() {
    //     return imagemCNH;
    // }

    // public void setImagemCNH(byte[] imagemCNH) {
    //     this.imagemCNH = imagemCNH;
    // }

    public Date getDataEntrada() {
        return data_entrada;
    }

    public void setDataEntrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCNH() {
        return cnh;
    }

    public void setCNH(String CNH) {
    try {
        if(validaCNH(CNH)){
            this.cnh = CNH;
        }else{
            throw new IllegalArgumentException("CNH invalida");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        
    }

    public static boolean validaCNH(String cnh) {
		char char1 = cnh.charAt(0);

		if (cnh.replaceAll("\\D+", "").length() != 11
				|| String.format("%0" + 11 + "d", 0).replace('0', char1).equals(cnh)) {
			return false;
		}

		long v = 0, j = 9;

		for (int i = 0; i < 9; ++i, --j) {
			v += ((cnh.charAt(i) - 48) * j);
		}

		long dsc = 0, vl1 = v % 11;

		if (vl1 >= 10) {
			vl1 = 0;
			dsc = 2;
		}

		v = 0;
		j = 1;

		for (int i = 0; i < 9; ++i, ++j) {
			v += ((cnh.charAt(i) - 48) * j);
		}

		long x = v % 11;
		long vl2 = (x >= 10) ? 0 : x - dsc;

		return (String.valueOf(vl1) + String.valueOf(vl2)).equals(cnh.substring(cnh.length() - 2));

	}

    
}
