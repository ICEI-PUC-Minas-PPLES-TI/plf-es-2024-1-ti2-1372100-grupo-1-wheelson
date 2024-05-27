package com.renatomatos.wheelson.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renatomatos.wheelson.models.Locador;
import com.renatomatos.wheelson.models.Locatario;
import com.renatomatos.wheelson.services.LocatarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/locatario")
@Validated
public class LocatarioController {

    @Autowired
    private LocatarioService locatarioService;

    @Operation(description = "Busca um locatario pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Locatario encontrado"),
            @ApiResponse(responseCode = "404", description = "Locatario não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Locatario> findById(@PathVariable Long id) {
        Locatario locatario = this.locatarioService.findById(id);
        return ResponseEntity.ok().body(locatario);
    }

    @Operation(description = "Busca todos os locatarios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de locatarios"),
            @ApiResponse(responseCode = "404", description = "Nenhum locatario encontrado")
    })
    @GetMapping
    public ResponseEntity<Iterable<Locatario>> findAll() {
        Iterable<Locatario> locatarios = this.locatarioService.findAll();
        return ResponseEntity.ok().body(locatarios);
    }

    @Operation(description = "Cria um novo locatario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Locatario criado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "409", description = "CNH inválida")
    })
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Locatario locatario) {
        this.locatarioService.create(locatario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                   .path("/{id}").buildAndExpand(locatario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(description = "Atualiza um locatario existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Locatario atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Locatario não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,@Valid @RequestBody Locatario locatario) {
        locatario.setId(id);
        this.locatarioService.update(locatario);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Exclui um locatario pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Locatario excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Locatario não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.locatarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Busca todos os locatarios com status falso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de locatarios com status falso"),
            @ApiResponse(responseCode = "404", description = "Nenhum locatario com status falso encontrado")
    })
    @GetMapping("/status/false")
    public ResponseEntity<List<Locatario>> findAllByStatusFalse() {
        List<Locatario> locatarios = (List<Locatario>) this.locatarioService.findAllByStatusFalse();
        return ResponseEntity.ok().body(locatarios);
    }

    @Operation(description = "Busca um locatario pelo email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Locatario encontrado"),
            @ApiResponse(responseCode = "404", description = "Locatario não encontrado")
    })
    @GetMapping("/email/{email}")
    public ResponseEntity<Locatario> findByEmail(@PathVariable String email) {
        Locatario locatario = this.locatarioService.findByEmail(email);
        return ResponseEntity.ok().body(locatario);
    }

    @Operation(description = "Busca um locatario pelo email e senha, rota para login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Locatario encontrado"),
            @ApiResponse(responseCode = "404", description = "Email não encontrado"),
            @ApiResponse(responseCode = "401", description = "Senha incorreta")
    })
    @GetMapping("login/{email}/{senha}")
    public ResponseEntity<Locatario> findByEmailAndSenha(@PathVariable String email, @PathVariable String senha) {
        Locatario locatario = this.locatarioService.findByEmailAndSenha(email, senha);
        return ResponseEntity.ok().body(locatario);
    }

    @Operation(description = "Atualiza o status de um locatario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Locatario atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Locatario não encontrado")
    })
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateStatus(@PathVariable Long id) {
        this.locatarioService.updateStatus(id);
        return ResponseEntity.noContent().build();
    }
}
 // @PostMapping
    // public ResponseEntity<Void> create(@ModelAttribute Locatario locatario,
    //                                    @RequestParam("imagemCNH") MultipartFile imagemCNH) {
    //     try {
    //         if (imagemCNH != null && !imagemCNH.isEmpty()) {
    //             locatario.setImagemCNH(imagemCNH.getBytes());
    //         }
    //         Locatario createdLocatario = this.locatarioService.create(locatario);
    //         URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
    //                 .path("/{id}").buildAndExpand(createdLocatario.getId()).toUri();
    //         return ResponseEntity.created(uri).build();
    //     } catch (Exception e) {
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    //     }
    // }



