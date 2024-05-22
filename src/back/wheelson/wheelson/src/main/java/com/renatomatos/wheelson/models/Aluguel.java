package com.renatomatos.wheelson.models;

import java.sql.Date;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Aluguel")
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
public class Aluguel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluguel")
    Long id_aluguel;

    @Column(name = "dataInicio", nullable = false)
    Date dataInicio;

    @Column(name = "dataFim", nullable = false)
    Date dataFim;

    @Column(name = "valorTotal", nullable = false)
    double valorTotal;

    @Column(name = "statusPago", nullable = false)
    boolean statusPago = false; // valor padrão

    @Column(name = "horarioInicio", nullable = false)
    String horarioInicio;

    @Column(name = "ativo", nullable = false)
    boolean ativo = true; // valor padrão

    @ManyToOne
    @JoinColumn(name = "id_carro", nullable = false, updatable = false)
    Carro carro;

    @ManyToOne
    @JoinColumn(name = "id_locador", nullable = false, updatable = false)
    Locador locador;

    @ManyToOne
    @JoinColumn(name = "id_locatario", nullable = false, updatable = false)
    Locatario locatario;

   
    @PrePersist
    protected void onCreate() {
        if (statusPago == false) {
            statusPago = false;
        }
        if (ativo == false) {
            ativo = true;
        }
    }
}
