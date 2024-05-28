package com.renatomatos.wheelson.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Problema")
@Getter
@Setter
public class Problema {

    @Id
    @Column(name = "id_problema")
    private Long id_problema;
    
    @NotEmpty
    @Column(name = "descricao", nullable = false, length = 100)
    private String descricao;

    @NotBlank
    @Column(name = "data", nullable = false)
    private Date data;

    @NotEmpty
    @Column(name = "valorExtra", nullable = true)
    private double valorExtra;

    @ManyToOne
    @JoinColumn(name = "id_aluguel", nullable = false)
    private Aluguel aluguel;
}
