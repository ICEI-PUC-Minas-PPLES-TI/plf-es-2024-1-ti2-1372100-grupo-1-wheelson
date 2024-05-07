package com.renatomatos.wheelson.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renatomatos.wheelson.models.Carro;
import com.renatomatos.wheelson.models.Locador;
import com.renatomatos.wheelson.repositories.CarroRepository;

import jakarta.transaction.Transactional;

@Service
public class CarroService {
    
    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private LocadorService locadorService;

    public Carro findById(Long id) {
        Optional<Carro> carro = this.carroRepository.findById(id);
        return carro.orElseThrow(() -> new RuntimeException("Carro  não encontrado: id: "+ id ));
    }

    @Transactional
    public Carro create(Carro carro){
        Locador locador = locadorService.findById(carro.getLocador().getId());
        carro.setId(null);
        carro.setLocador(locador);
        carro = this.carroRepository.save(carro);
        return carro;
    }

    @Transactional
    public Carro update(Carro carro){
        Carro newCarro = findById(carro.getId());
        newCarro.setValorDiario(carro.getValorDiario());
        newCarro.setDisponivel(carro.isDisponivel());
        return this.carroRepository.save(newCarro);
    }

    @Transactional
    public void delete(Long id){
        findById(id);
        try {
            carroRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível deletar o carro pois há entidades relacionadas!");
        }
    }

}
