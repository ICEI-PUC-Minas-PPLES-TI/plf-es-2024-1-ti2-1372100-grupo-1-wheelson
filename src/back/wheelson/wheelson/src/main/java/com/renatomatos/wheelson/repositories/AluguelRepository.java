package com.renatomatos.wheelson.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.renatomatos.wheelson.models.Aluguel;
@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long>{

    List<Aluguel> findByLocatarioId(Long id);

    List<Aluguel> findByLocadorId(Long id);

    List<Aluguel> findByCarroId(Long id);
    
}
