package com.renatomatos.wheelson.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renatomatos.wheelson.models.Carro;
import com.renatomatos.wheelson.models.PontoDeEncontro;
import com.renatomatos.wheelson.services.CarroService;
import com.renatomatos.wheelson.services.PontoDeEncontroService;

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
@RequestMapping("/PontoDeEncontro")
//@Validated
public class PontoDeEncontroController {

    @Autowired
    private PontoDeEncontroService PontodeEncontroService;
    
    @Operation(description = "Busca um ponto de encontro pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ponto de encontro encontrado"),
            @ApiResponse(responseCode = "404", description = "Ponto de encontro não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PontoDeEncontro> findById(@PathVariable Long id){
        PontoDeEncontro pontoDeEncontro = this.PontodeEncontroService.findById(id);
        return ResponseEntity.ok().body(pontoDeEncontro);
    }
    
    @Operation(description = "Cria um novo ponto de encontro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "ponto de encontro criado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping
    public ResponseEntity<Void> create(/*@Valid*/ @RequestBody PontoDeEncontro pontoDeEncontro) {
         this.PontodeEncontroService.create(pontoDeEncontro);
         URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(pontoDeEncontro.getId()).toUri() ;
         return ResponseEntity.created(uri).build();
    }

    @Operation(description = "Atualiza um ponto de encontro existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Ponto de encontro atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ponto de encontro não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, /*@Valid*/ @RequestBody PontoDeEncontro pEncontro) {
        pEncontro.setId(id);
        this.PontodeEncontroService.update(pEncontro);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Exclui um ponto de encontro pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Ponto de encontro excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ponto de encontro não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.PontodeEncontroService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Busca todos os pontos de encontros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de pontos de encontro"),
            @ApiResponse(responseCode = "404", description = "Nenhum ponto de encontro encontrado")
    })
    @GetMapping
    public ResponseEntity<List<PontoDeEncontro>> findAll() {
        List<PontoDeEncontro> pontos = this.PontodeEncontroService.findAll();
        return ResponseEntity.ok().body(pontos);
    }


}
