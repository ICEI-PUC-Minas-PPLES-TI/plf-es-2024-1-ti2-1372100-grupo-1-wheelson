package com.renatomatos.wheelson.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renatomatos.wheelson.models.PontoDeEncontro;
import com.renatomatos.wheelson.services.CarroService;
import com.renatomatos.wheelson.services.PontoDeEncontroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("/pontoDeEncontro")
@Validated
public class PontoDeEncontroController {

    @Autowired
    private PontoDeEncontroService pontoDeEncontroService;

    @Autowired
    private CarroService carroService;

    @Operation(description = "Busca um ponto de encontro pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "404", description = "Ponto de encontro não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PontoDeEncontro> findById(@PathVariable Long id) {
        PontoDeEncontro pontoDeEncontro = pontoDeEncontroService.findById(id);
        return ResponseEntity.ok().body(pontoDeEncontro);
    }

    @Operation(description = "Retorna todos os pontos de encontro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso")
    })
    @GetMapping
    public ResponseEntity<List<PontoDeEncontro>> findAll() {
        List<PontoDeEncontro> pontos = pontoDeEncontroService.findAll();
        return ResponseEntity.ok().body(pontos);
    }

    @Operation(description = "Adiciona um novo ponto de encontro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Criado"),
            @ApiResponse(responseCode = "400", description = "Erro de validação")
    })
    @PostMapping
    public ResponseEntity<PontoDeEncontro> create(@Valid @RequestBody PontoDeEncontro pontoDeEncontro) {
        PontoDeEncontro newPontoDeEncontro = pontoDeEncontroService.create(pontoDeEncontro);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newPontoDeEncontro.getId()).toUri();
        return ResponseEntity.created(uri).body(newPontoDeEncontro);
    }

    @Operation(description = "Atualiza um ponto de encontro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação"),
            @ApiResponse(responseCode = "404", description = "Ponto de encontro não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<PontoDeEncontro> update(@PathVariable Long id, @Valid @RequestBody PontoDeEncontro pontoDeEncontro) {
        pontoDeEncontro.setId(id);
        PontoDeEncontro updatedPontoDeEncontro = pontoDeEncontroService.update(pontoDeEncontro);
        return ResponseEntity.ok().body(updatedPontoDeEncontro);
    }

    @Operation(description = "Deleta um ponto de encontro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Sem conteúdo"),
            @ApiResponse(responseCode = "404", description = "Ponto de encontro não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pontoDeEncontroService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/carro/{id}")
    public ResponseEntity<List<PontoDeEncontro>> findByCarro(@PathVariable Long id) {
        List<PontoDeEncontro> pontos = pontoDeEncontroService.findByCarro(carroService.findById(id));
        return ResponseEntity.ok().body(pontos);
    }
}
