package com.renatomatos.wheelson.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renatomatos.wheelson.models.Locatario;

public interface LocatarioRepository extends JpaRepository<Locatario, Long> {

    Optional<Locatario> findByEmail(String email);


    
    
}
