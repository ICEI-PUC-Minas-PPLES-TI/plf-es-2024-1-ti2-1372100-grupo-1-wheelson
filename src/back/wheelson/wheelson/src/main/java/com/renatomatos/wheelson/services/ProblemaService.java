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
        return problemaRepository.findAll();
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
        return problemaRepository.save(problema);
    }

    @Transactional
    public Problema update(Problema problema) {
        Problema newProblema = findById(problema.getId_problema());
        newProblema.setDescricao(problema.getDescricao());
        newProblema.setData(problema.getData());
        newProblema.setValorExtra(problema.getValorExtra());
        return problemaRepository.save(newProblema);
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
