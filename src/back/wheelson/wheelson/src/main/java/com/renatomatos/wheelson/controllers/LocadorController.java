package com.renatomatos.wheelson.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renatomatos.wheelson.models.Locador;
import com.renatomatos.wheelson.services.LocadorService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/locador")
//@Validated USAR ESSE VALIDATED CASO SEJA USADO VALIDACOES @NOTNULL, @NOTEMPTY, ETC NO MODELS
public class LocadorController {

    @Autowired
    private LocadorService locadorService;

    //localhost:8080/locador/1
    @GetMapping("/{id}")
    public ResponseEntity<Locador> findById(@PathVariable Long id){
        Locador locador = this.locadorService.findById(id);
        return ResponseEntity.ok().body(locador);
    }

    @PostMapping
    public ResponseEntity<Void> create( @RequestBody Locador locador){
         this.locadorService.create(locador);
         URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(locador.getId()).toUri() ;
         return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Locador locador) {
        locador.setId(id);
        this.locadorService.update(locador);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.locadorService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    
}
