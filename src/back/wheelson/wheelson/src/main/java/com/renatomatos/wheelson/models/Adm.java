package com.renatomatos.wheelson.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Adm
 */
@Entity
@Table(name = "Adm")
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
public class Adm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adm")
    private Long id_adm;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;
}