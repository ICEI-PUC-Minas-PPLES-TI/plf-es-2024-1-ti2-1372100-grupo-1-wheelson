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
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Problema")
@Getter
@Setter
@EqualsAndHashCode
public class Problema {

    @Id
    @Column(name = "id_problema")
    private Long id_problema;
    
    @NotEmpty(message = "O campo descrição não pode ser vazio")
    @Column(name = "descricao", nullable = false, length = 100)
    private String descricao;

    @NotEmpty(message = "O campo data não pode ser vazio")
    @Column(name = "data", nullable = false)
    private Date data;

    
    @Column(name = "valorExtra", nullable = true)
    private double valorExtra;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_aluguel", nullable = false, updatable = false)
    private Aluguel aluguel;

    public Aluguel getAluguel() {
        return aluguel;
    }
}
