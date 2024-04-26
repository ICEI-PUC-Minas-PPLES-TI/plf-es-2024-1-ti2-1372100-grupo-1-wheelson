package com.renatomatos.wheelson.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renatomatos.wheelson.models.Locador;
import com.renatomatos.wheelson.repositories.LocadorRepository;

import jakarta.transaction.Transactional;

@Service
public class LocadorService {
    
    @Autowired
    private LocadorRepository locadorRepository;

    public void save(Locador locador) {
        locadorRepository.save(locador);
    }

    public Locador findById(Long id) {
        Optional<Locador> locador = locadorRepository.findById(id);
        return locador.orElseThrow(() -> new RuntimeException("Locador não encontrado"));
    }

    @Transactional
    public Locador create(Locador locador) {
        return this.locadorRepository.save(locador);
    }

    @Transactional
    public Locador update(Locador locador) {
        Locador newLocador = findById(locador.getId());
        newLocador.setNome(locador.getNome());
        newLocador.setEmail(locador.getEmail());
        newLocador.setTelefone(locador.getTelefone());
        newLocador.setRua(locador.getRua());
        newLocador.setBairro(locador.getBairro());
        newLocador.setNumero_resid(locador.getNumero_resid());
        newLocador.setCidade(locador.getCidade());
        newLocador.setuf(locador.getuf());
        newLocador.setStatus(locador.getStatus());
        newLocador.setSaldo(locador.getSaldo());
        return this.locadorRepository.save(newLocador);
        
    }

    @Transactional
    public void delete(Long id) {
        findById(id);
        try {
            locadorRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível deletar o locador pois há entidades relacionadas!");
        }
        
    }
}
