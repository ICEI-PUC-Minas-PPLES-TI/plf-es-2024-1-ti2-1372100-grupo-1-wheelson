package com.renatomatos.wheelson.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renatomatos.wheelson.models.Carro;
import com.renatomatos.wheelson.services.CarroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

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
//@Validated
public class CarroController {

    @Autowired
    private CarroService carroService;
    
    @Operation(description = "Busca um carro pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carro encontrado"),
            @ApiResponse(responseCode = "404", description = "Carro não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Carro> findById(@PathVariable Long id){
        Carro carro = this.carroService.findById(id);
        return ResponseEntity.ok().body(carro);
    }
    
    @Operation(description = "Cria um novo carro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Carro criado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping
    public ResponseEntity<Void> create(/*@Valid*/ @RequestBody Carro carro) {
         this.carroService.create(carro);
         URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(carro.getId()).toUri() ;
         return ResponseEntity.created(uri).build();
    }

    @Operation(description = "Atualiza um carro existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Carro atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Carro não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, /*@Valid*/ @RequestBody Carro carro) {
        carro.setId(id);
        this.carroService.update(carro);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Exclui um carro pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Carro excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Carro não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.carroService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Busca todos os carros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de carros"),
            @ApiResponse(responseCode = "404", description = "Nenhum carro encontrado")
    })
    @GetMapping("/all")
    public ResponseEntity<List<Carro>> findAll() {
        List<Carro> carros = this.carroService.findAll();
        return ResponseEntity.ok().body(carros);
    }

    @Operation(description = "Busca todos os carros de um determinado locador pelo ID do locador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de carros do locador"),
            @ApiResponse(responseCode = "404", description = "Nenhum carro encontrado para o locador")
    })
    @GetMapping("/locador/{id}")
    public ResponseEntity<List<Carro>> findByLocadorId(@PathVariable Long id) {
        List<Carro> carros = this.carroService.findByLocadorId(id);
        return ResponseEntity.ok().body(carros);
    }
}
