package com.renatomatos.wheelson.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renatomatos.wheelson.models.Problema;
import com.renatomatos.wheelson.services.ProblemaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/problema")
@Validated
public class ProblemaController {
    

    @Autowired
    private ProblemaService problemaService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Problema> findById(@PathVariable Long id) {
        Problema problema = problemaService.findById(id);
        return ResponseEntity.ok().body(problema);
    }

    @GetMapping
    public ResponseEntity<List<Problema>> findAll() {
        List<Problema> problema = problemaService.findAll();
        return ResponseEntity.ok().body(problema);
    }

    @GetMapping("/aluguel/{id}")
    public ResponseEntity<List<Problema>> findByAluguel(@PathVariable Long id) {
        List<Problema> problema = problemaService.findByAluguel(id);
        return ResponseEntity.ok().body(problema);
    }

    @PostMapping
    public ResponseEntity<Problema> create( @RequestBody Problema problema) {
         this.problemaService.create(problema);
         URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(problema.getId_problema()).toUri() ;
         return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<Problema> update(Problema problema) {
        Problema newProblema = problemaService.update(problema);
        return ResponseEntity.ok().body(newProblema);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        problemaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
