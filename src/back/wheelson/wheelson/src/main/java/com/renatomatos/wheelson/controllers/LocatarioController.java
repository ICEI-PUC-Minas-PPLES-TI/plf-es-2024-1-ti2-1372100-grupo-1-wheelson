package com.renatomatos.wheelson.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renatomatos.wheelson.models.Locador;
import com.renatomatos.wheelson.models.Locatario;
import com.renatomatos.wheelson.services.LocatarioService;

@RestController
@RequestMapping("/locatario")
public class LocatarioController {

    @Autowired
    private LocatarioService locatarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Locatario> findById(@PathVariable Long id) {
        Locatario locatario = this.locatarioService.findById(id);
        return ResponseEntity.ok().body(locatario);
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
    @PostMapping
    public ResponseEntity<Void> create( @RequestBody Locatario locatario){
         this.locatarioService.create(locatario);
         URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(locatario.getId()).toUri() ;
         return ResponseEntity.created(uri).build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Locatario locatario) {
        locatario.setId(id);
        this.locatarioService.update(locatario);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.locatarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

