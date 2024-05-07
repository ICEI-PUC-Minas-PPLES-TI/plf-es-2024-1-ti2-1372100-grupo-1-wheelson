package com.renatomatos.wheelson.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renatomatos.wheelson.models.Carro;

@Repository
public interface CarroRepository  extends JpaRepository<Carro, Long>{
    
    List<Carro> findByLocadorId(Long locadorId);

    
}
