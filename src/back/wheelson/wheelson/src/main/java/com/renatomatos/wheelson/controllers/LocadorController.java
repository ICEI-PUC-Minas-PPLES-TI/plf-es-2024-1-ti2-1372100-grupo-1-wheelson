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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renatomatos.wheelson.models.Locador;
import com.renatomatos.wheelson.models.Locatario;
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

    @GetMapping
    public ResponseEntity<Iterable<Locador>> findAll(){
        Iterable<Locador> locadores = this.locadorService.findAll();
        return ResponseEntity.ok().body(locadores);
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
    
      @GetMapping("/status/false")
public ResponseEntity<List<Locador>> findAllByStatusFalse() {
    List<Locador> locadores = (List<Locador>) this.locadorService.findAllByStatusFalse();
    return ResponseEntity.ok().body(locadores);
}

@GetMapping("/email/{email}")
public ResponseEntity<Locador> findByEmail(@PathVariable String email) {
    Locador locador = this.locadorService.findByEmail(email);
    return ResponseEntity.ok().body(locador);
}

//login
@GetMapping("login/{email}/{senha}")
public ResponseEntity<Locador> findByEmailAndSenha(@PathVariable String email, @PathVariable String senha) {
    Locador locador = this.locadorService.findByEmailAndSenha(email, senha);
    return ResponseEntity.ok().body(locador);
}
    
}
