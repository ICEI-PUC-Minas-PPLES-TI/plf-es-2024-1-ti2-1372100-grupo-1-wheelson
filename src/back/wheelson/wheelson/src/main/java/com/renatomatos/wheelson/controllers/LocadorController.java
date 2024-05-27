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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renatomatos.wheelson.models.Locador;
import com.renatomatos.wheelson.models.Locatario;
import com.renatomatos.wheelson.services.LocadorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/locador")
@Validated //USAR ESSE VALIDATED CASO SEJA USADO VALIDACOES @NOTNULL, @NOTEMPTY, ETC NO MODELS
public class LocadorController {

    @Autowired
    private LocadorService locadorService;

    //localhost:8080/locador/1
    @Operation(description = "Busca um locador pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Locador encontrado"),
            @ApiResponse(responseCode = "404", description = "Locador não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Locador> findById(@PathVariable Long id){
        Locador locador = this.locadorService.findById(id);
        return ResponseEntity.ok().body(locador);
    }

    @Operation(description = "Busca todos os locadores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de locadores"),
            @ApiResponse(responseCode = "404", description = "Nenhum locador encontrado")
    })
    @GetMapping
    public ResponseEntity<Iterable<Locador>> findAll(){
        Iterable<Locador> locadores = this.locadorService.findAll();
        return ResponseEntity.ok().body(locadores);
    }

    @Operation(description = "Cria um novo locador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Locador criado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Locador locador){
         this.locadorService.create(locador);
         URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(locador.getId()).toUri() ;
         return ResponseEntity.created(uri).build();
    }

    @Operation(description = "Atualiza um locador existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Locador atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Locador não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,@Valid @RequestBody Locador locador) {
        locador.setId(id);
        this.locadorService.update(locador);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Exclui um locador pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Locador excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Locador não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.locadorService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @Operation(description = "Busca todos os locadores com status falso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de locadores com status falso"),
            @ApiResponse(responseCode = "404", description = "Nenhum locador com status falso encontrado")
    })
    @GetMapping("/status/false")
    public ResponseEntity<List<Locador>> findAllByStatusFalse() {
        List<Locador> locadores = (List<Locador>) this.locadorService.findAllByStatusFalse();
        return ResponseEntity.ok().body(locadores);
    }

    @Operation(description = "Busca um locador pelo email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Locador encontrado"),
            @ApiResponse(responseCode = "404", description = "Locador não encontrado")
    })
    @GetMapping("/email/{email}")
    public ResponseEntity<Locador> findByEmail(@PathVariable String email) {
        Locador locador = this.locadorService.findByEmail(email);
        return ResponseEntity.ok().body(locador);
    }

    @Operation(description = "Busca um locador pelo email e senha, rota para login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Locador encontrado"),
            @ApiResponse(responseCode = "404", description = "Email não encontrado"),
            @ApiResponse(responseCode = "401", description = "Senha incorreta")
    })
    @GetMapping("login/{email}/{senha}")
    public ResponseEntity<Locador> findByEmailAndSenha(@PathVariable String email, @PathVariable String senha) {
        Locador locador = this.locadorService.findByEmailAndSenha(email, senha);
        return ResponseEntity.ok().body(locador);
    }

    @Operation(description = "Atualiza o status de um locador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Status do locador atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Locador não encontrado")
    })
    @PatchMapping("/status/{id}")
    public ResponseEntity<Void> updateStatus(@PathVariable Long id) {
        this.locadorService.updateStatus(id);
        return ResponseEntity.noContent().build();
    }
}
