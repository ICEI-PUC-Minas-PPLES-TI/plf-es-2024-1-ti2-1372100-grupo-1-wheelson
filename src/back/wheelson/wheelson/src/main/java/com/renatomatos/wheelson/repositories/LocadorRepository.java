package com.renatomatos.wheelson.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renatomatos.wheelson.models.Locador;


public interface LocadorRepository extends JpaRepository<Locador, Long>{

    Optional<Locador> findByEmail(String email);
    
}
