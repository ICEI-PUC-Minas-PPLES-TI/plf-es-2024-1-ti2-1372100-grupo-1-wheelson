package com.renatomatos.wheelson.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renatomatos.wheelson.models.Adm;

@Repository
public interface AdmRepository extends JpaRepository<Adm, Long>{

    //Optional<Adm> findByEmailAndPassword(String email, String password);

    Optional<Adm> findByEmail(String email);
    
}
