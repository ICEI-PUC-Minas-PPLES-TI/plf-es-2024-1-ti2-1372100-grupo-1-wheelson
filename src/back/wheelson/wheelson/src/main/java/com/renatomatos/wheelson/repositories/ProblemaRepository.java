package com.renatomatos.wheelson.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renatomatos.wheelson.models.Problema;

@Repository
public interface ProblemaRepository extends JpaRepository<Problema, Long>{

    List<Problema> findByIdAluguel(Long id_aluguel);
    
}
