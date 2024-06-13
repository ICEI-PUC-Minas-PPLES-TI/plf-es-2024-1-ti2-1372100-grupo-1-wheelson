package com.renatomatos.wheelson.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.renatomatos.wheelson.util.StateAluguelEnum;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Aluguel")
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
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

    @NotBlank
    @Column(name = "horarioInicio", nullable = false)
    String horarioInicio;

    @Column(name = "estado", nullable = false)
    StateAluguelEnum  estado = StateAluguelEnum.ATIVO; // valor padrão

    @ManyToOne
    @JoinColumn(name = "id_carro", nullable = false, updatable = false)
    Carro carro;

    @ManyToOne
    @JoinColumn(name = "id_locador", nullable = false, updatable = false)
    Locador locador;

    @ManyToOne
    @JoinColumn(name = "id_locatario", nullable = false, updatable = false)
    Locatario locatario;

    @OneToMany(mappedBy = "aluguel")
    List<Problema> problema;

   
    @PrePersist
    protected void onCreate() {
        if (statusPago == false) {
            statusPago = false;
        }
        
            estado = StateAluguelEnum.ATIVO;
        
    }
    @JsonIgnore
    public List<Problema> getProblema() {
        if (problema == null) {
            problema = new ArrayList<>();
        }
        return problema;
    }
}
