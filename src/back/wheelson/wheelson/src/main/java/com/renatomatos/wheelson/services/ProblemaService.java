package com.renatomatos.wheelson.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renatomatos.wheelson.models.Aluguel;
import com.renatomatos.wheelson.models.Problema;
import com.renatomatos.wheelson.repositories.ProblemaRepository;

import jakarta.transaction.Transactional;

@Service
public class ProblemaService {

    @Autowired
    private ProblemaRepository problemaRepository;

    @Autowired
    private AluguelService aluguelService;

    public Problema findById(Long id) {
        Optional<Problema> problema = problemaRepository.findById(id);
        return problema.orElseThrow(() -> new RuntimeException("Problema não encontrado"));
    }

    public List<Problema> findAll() {
        List<Problema> problemas = (List<Problema>) this.problemaRepository.findAll();
        return problemas;
    }

    public List<Problema> findByAluguel(Long id) {
        Aluguel aluguel = aluguelService.findById(id);
        return problemaRepository.findByAluguel(aluguel);
    }

    @Transactional
    public Problema create(Problema problema) {
        problema.setId_problema(null);
        Aluguel aluguel = aluguelService.findById(problema.getAluguel().getId_aluguel());
        problema.setAluguel(aluguel);
        problema = this.problemaRepository.save(problema);
        return problema;
    }

    @Transactional
    public Problema update(Problema problema) {
        Problema newProblema = findById(problema.getId_problema());
        newProblema.setDescricao(problema.getDescricao());
        newProblema.setValorExtra(problema.getValorExtra());
        return this.problemaRepository.save(newProblema);
    }

    @Transactional
    public void delete(Long id) {
        findById(id);
        try {
            problemaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível deletar o problema pois há entidades relacionadas!");
        }
    }
}
