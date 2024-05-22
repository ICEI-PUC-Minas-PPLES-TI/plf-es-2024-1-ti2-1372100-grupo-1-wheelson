package com.renatomatos.wheelson.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renatomatos.wheelson.models.Aluguel;
import com.renatomatos.wheelson.repositories.AluguelRepository;

import jakarta.transaction.Transactional;

@Service
public class AluguelService {
    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private CarroService carroService;

    @Autowired
    private LocatarioService locatarioService;

    @Autowired
    private LocadorService locadorService;

    public void save(Aluguel aluguel) {
        aluguelRepository.save(aluguel);
    }

    public Aluguel findById(Long id){
        Optional<Aluguel> aluguel = aluguelRepository.findById(id);
        return aluguel.orElseThrow(() -> new RuntimeException("Aluguel não encontrado"));
    }

    @Transactional
    public Aluguel create(Aluguel aluguel){
        aluguel.setId_aluguel(null);
        aluguel.setCarro(carroService.findById(aluguel.getCarro().getId()));
        aluguel.setLocatario(locatarioService.findById(aluguel.getLocatario().getId()));
        aluguel.setLocador(locadorService.findById(aluguel.getLocador().getId()));
        aluguel = this.aluguelRepository.save(aluguel);
        return aluguel;
}

@Transactional
public Aluguel updatePartial(Long id, Map<String, Object> updates) {
    Aluguel aluguel = findById(id);
    updates.forEach((key, value) -> {
        switch (key) {
            case "statusPago":
                aluguel.setStatusPago((Boolean) value);
                break;
            case "ativo":
                aluguel.setAtivo((Boolean) value);
                break;
                case "valorTotal":
                aluguel.setValorTotal((Double) value);
                break;
        }
    });
    return aluguelRepository.save(aluguel);
}

    @Transactional
    public void delete(Long id){
        findById(id);
        try {
            aluguelRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível deletar o aluguel pois há entidades relacionadas!");
        }
    }

    @Transactional
    public List<Aluguel> findAll() {
        List<Aluguel> alugueis = (List<Aluguel>) this.aluguelRepository.findAll();
        return alugueis;
    }

    @Transactional
    public List<Aluguel> findByLocatarioId(Long id) {
        List<Aluguel> alugueis = this.aluguelRepository.findByLocatarioId(id);
        return alugueis;
    }

    @Transactional
    public List<Aluguel> findByLocadorId(Long id) {
        List<Aluguel> alugueis = this.aluguelRepository.findByLocadorId(id);
        return alugueis;
    }

    @Transactional
    public List<Aluguel> findByCarroId(Long id) {
        List<Aluguel> alugueis = this.aluguelRepository.findByCarroId(id);
        return alugueis;
    }


}
