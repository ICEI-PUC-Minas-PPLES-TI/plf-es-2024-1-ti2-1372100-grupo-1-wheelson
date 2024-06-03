package com.renatomatos.wheelson.services;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.renatomatos.wheelson.models.PontoDeEncontro;
import com.renatomatos.wheelson.repositories.PontoDeEncontroRepository;
import com.renatomatos.wheelson.models.Carro;
import com.renatomatos.wheelson.models.Locador;

import jakarta.transaction.Transactional;

@Service
public class PontoDeEncontroService {
    
    @Autowired
    private PontoDeEncontroRepository PontoDeEncontroRepository;

    @Autowired 
    private CarroService carroService;

   
    public PontoDeEncontro findById(Long id) {
        Optional<PontoDeEncontro> pencontro = this.PontoDeEncontroRepository.findById(id);
        return pencontro.orElseThrow(() -> new RuntimeException("Ponto de encontro não encontrado: id: "+ id ));
    }

    @Transactional
    public PontoDeEncontro create(PontoDeEncontro pencontro){
        pencontro.setId(null);
        Carro carro = carroService.findById(pencontro.getCarro().getId());
        pencontro.setCarro(carro);
        pencontro = this.PontoDeEncontroRepository.save(pencontro);
        return pencontro;
    }

    @Transactional
    public PontoDeEncontro update(PontoDeEncontro pencontro){
        PontoDeEncontro newPontoDeEncontro = findById(pencontro.getId());
        
        return this.PontoDeEncontroRepository.save(newPontoDeEncontro);
    }

    @Transactional
    public void delete(Long id){
        findById(id);
        try {
            PontoDeEncontroRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível deletar o ponto de encontro pois há entidades relacionadas!");
        }
    }
    //Ordenar por disponibilidade
    @Transactional
    public List<PontoDeEncontro> findAll() {
        List<PontoDeEncontro> pontos =(List<PontoDeEncontro>) this.PontoDeEncontroRepository.findAll();
        return pontos;
    }

    public List<PontoDeEncontro> findByCarro(Carro carro) {
        List<PontoDeEncontro> pontos = this.PontoDeEncontroRepository.findByCarro(carro);
        return pontos;
    }

    
    // public ResponseEntity<List<Carro>> findByDisponivel(boolean disponivel) {
    //     List<Carro> carros = this.carroRepository.findByDisponivel(disponivel);
    //     return ResponseEntity.ok().body(carros);
    // }

}
