package com.renatomatos.wheelson.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renatomatos.wheelson.models.PontoDeEncontro;

@Repository
public interface PontoDeEncontroRepository  extends JpaRepository<PontoDeEncontro, Long>{
    
    
    
}