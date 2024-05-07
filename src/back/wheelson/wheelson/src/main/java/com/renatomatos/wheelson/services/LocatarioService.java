package com.renatomatos.wheelson.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renatomatos.wheelson.models.Locador;
import com.renatomatos.wheelson.models.Locatario;
import com.renatomatos.wheelson.repositories.LocatarioRepository;

import jakarta.transaction.Transactional;

@Service
public class LocatarioService {

    @Autowired
    private LocatarioRepository locatarioRepository;

    public void save(Locatario locatario) {
        locatarioRepository.save(locatario);
    }

    public Locatario findById(Long id) {
        Optional<Locatario> locatario = locatarioRepository.findById(id);
        return locatario.orElseThrow(() -> new RuntimeException("Locatario não encontrado"));
    }

    @Transactional
    public Locatario create(Locatario locatario) {
        return this.locatarioRepository.save(locatario);
    }

    @Transactional
    public Locatario update(Locatario locatario) {
        Locatario newLocador = findById(locatario.getId());
        newLocador.setNome(locatario.getNome());
        newLocador.setEmail(locatario.getEmail());
        newLocador.setTelefone(locatario.getTelefone());
        newLocador.setRua(locatario.getRua());
        newLocador.setBairro(locatario.getBairro());
        newLocador.setNumeroResid(locatario.getNumeroResid());
        newLocador.setCidade(locatario.getCidade());
        newLocador.setUF(locatario.getUF());
        newLocador.setStatus(locatario.isStatus());
        
        return this.locatarioRepository.save(newLocador);
        
    }

    @Transactional
    public void delete(Long id) {
        findById(id);
        try {
            locatarioRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível deletar o locatario pois há entidades relacionadas!");
        }
        
    }
    //getall
    public Iterable<Locatario> findAll() {
        return locatarioRepository.findAll();
    }

    
}
