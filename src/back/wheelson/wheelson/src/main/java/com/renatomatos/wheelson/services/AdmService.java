package com.renatomatos.wheelson.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renatomatos.wheelson.exceptions.EmailNotFoundException;
import com.renatomatos.wheelson.exceptions.SenhaIncorretaException;
import com.renatomatos.wheelson.models.Adm;

import com.renatomatos.wheelson.repositories.AdmRepository;

import jakarta.transaction.Transactional;

@Service
public class AdmService {
    @Autowired
    private AdmRepository admRepository;

    public boolean login(String email, String password) {
        return findByEmailAndPassword(email, password) != null;
    }

     private Adm findByEmailAndPassword(String email, String password) {
        Optional<Adm> adm = admRepository.findByEmail(email);
        if (adm.isPresent()) {
            if (adm.get().getPassword().equals(password)) {
                return adm.get();
            }
            throw new SenhaIncorretaException();
        }
        throw new EmailNotFoundException(email);
    }

    @Transactional
    public Adm create(Adm adm) {
        return admRepository.save(adm);
    }

    public void save(Adm adm) {
        admRepository.save(adm);
    }
}

