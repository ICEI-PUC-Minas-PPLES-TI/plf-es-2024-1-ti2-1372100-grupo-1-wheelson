package com.renatomatos.wheelson.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renatomatos.wheelson.models.Problema;
import com.renatomatos.wheelson.services.ProblemaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/problema")
//@Validated
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
        List<Problema> problemas = problemaService.findAll();
        return ResponseEntity.ok().body(problemas);
    }

    @GetMapping("/resolvido")
    public ResponseEntity<List<Problema>> findAllByResolvido() {
        List<Problema> problemas = problemaService.findAllByResolvido();
        return ResponseEntity.ok().body(problemas);
    }

    @GetMapping("/naoResolvido")
    public ResponseEntity<List<Problema>> findAllByNotResolvido() {
        List<Problema> problemas = problemaService.findAllByNotResolvido();
        return ResponseEntity.ok().body(problemas);
    }

    @GetMapping("/aluguel/{id}")
    public ResponseEntity<List<Problema>> findByAluguel(@PathVariable Long id) {
        List<Problema> problemas = problemaService.findByAluguel(id);
        return ResponseEntity.ok().body(problemas);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody /*@Valid*/ Problema problema) {
        this.problemaService.create(problema);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                                             .path("/{id}")
                                             .buildAndExpand(problema.getId_problema())
                                             .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Problema> update(@PathVariable Long id, @RequestBody /*@Valid*/ Problema problema) {
        problema.setId_problema(id);
        Problema updatedProblema = problemaService.update(problema);
        return ResponseEntity.ok().body(updatedProblema);
    }

    @PutMapping("/resolver/{id}/{valor}")
    public ResponseEntity<Problema> resolverProblema(@PathVariable Long id, @PathVariable double valor) {
        Problema problema = problemaService.resolverProblema(valor, id);
        return ResponseEntity.ok().body(problema);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        problemaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
