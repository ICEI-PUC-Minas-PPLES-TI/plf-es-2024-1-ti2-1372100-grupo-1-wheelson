package com.renatomatos.wheelson.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renatomatos.wheelson.models.Carro;
import com.renatomatos.wheelson.services.CarroService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;
import java.net.URI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/carro")
public class CarroController {


    @Autowired
    private CarroService carroService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Carro> findById(@PathVariable Long id){
        Carro carro = this.carroService.findById(id);
        return ResponseEntity.ok().body(carro);
    }
    

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Carro carro) {
         this.carroService.create(carro);
         URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(carro.getId()).toUri() ;
         return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Carro carro) {
        carro.setId(id);
        this.carroService.update(carro);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.carroService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Carro>> findAll() {
        List<Carro> carros =this.carroService.findAll();
        return ResponseEntity.ok().body(carros);
    }
    

    @GetMapping("/locador/{id}")
    public ResponseEntity<List<Carro>> findByLocadorId(@PathVariable Long id) {
        List<Carro> carros = this.carroService.findByLocadorId(id);
        return ResponseEntity.ok().body(carros);
    }
    
}