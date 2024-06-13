package com.renatomatos.wheelson.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Problema")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public class Problema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_problema")
    private Long id_problema;
    
    //@NotEmpty(message = "O campo descrição não pode ser vazio")
    @Column(name = "descricao", nullable = false, length = 100)
    private String descricao;

   // @NotEmpty(message = "O campo data não pode ser vazio")
    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "valorExtra", nullable = true)
    private double valorExtra;

    @Column(name = "resolvido")
    //ao iniciar um problema, ele não está resolvido
    private boolean resolvido = false;

    @ManyToOne
    @JoinColumn(name = "id_aluguel", nullable = false, updatable = false)
    private Aluguel aluguel;

    @PrePersist
    protected void onCreate() {
        resolvido = false;
        
    }
}
