package com.renatomatos.wheelson.services;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.renatomatos.wheelson.models.Carro;
import com.renatomatos.wheelson.models.Locador;
import com.renatomatos.wheelson.models.PontoDeEncontro;
import com.renatomatos.wheelson.repositories.CarroRepository;

import jakarta.transaction.Transactional;

@Service
public class CarroService {
    
    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private LocadorService locadorService;

    @Autowired
    private PontoDeEncontroService pontoDeEncontroService;

    public Carro findById(Long id) {
        Optional<Carro> carro = this.carroRepository.findById(id);
        return carro.orElseThrow(() -> new RuntimeException("Carro  não encontrado: id: "+ id ));
    }

    @Transactional
    public Carro create(Carro carro){
        Locador locador = locadorService.findById(carro.getLocador().getId());
        PontoDeEncontro ponto= pontoDeEncontroService.findById(carro.getPontoDeEncontro().getId());
        carro.setId(null);
        carro.setLocador(locador);
        carro.setPontoDeEncontro(ponto);
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
    //Ordenar por disponibilidade
    @Transactional
    public List<Carro> findAll() {
        List<Carro> carros =(List<Carro>) this.carroRepository.findAll();
        return  carros.stream()
        .sorted((c1, c2) -> Boolean.compare(c2.isDisponivel(), c1.isDisponivel()))
        .collect(Collectors.toList());
    }

    @Transactional
    public List<Carro> findByLocadorId(Long id) {
        List<Carro> carros = this.carroRepository.findByLocadorId(id);
        return carros;
    }
    // public ResponseEntity<List<Carro>> findByDisponivel(boolean disponivel) {
    //     List<Carro> carros = this.carroRepository.findByDisponivel(disponivel);
    //     return ResponseEntity.ok().body(carros);
    // }

}