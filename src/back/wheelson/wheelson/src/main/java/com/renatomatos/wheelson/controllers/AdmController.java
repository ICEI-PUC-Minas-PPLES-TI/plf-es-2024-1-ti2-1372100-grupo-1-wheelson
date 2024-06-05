package com.renatomatos.wheelson.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renatomatos.wheelson.models.Adm;
import com.renatomatos.wheelson.services.AdmService;



/**
 * AdmController
 */
@RestController
@RequestMapping("/adm")
public class AdmController {

    @Autowired
    private AdmService admService;

    @GetMapping("/login/{email}/{password}")
    public boolean login(@PathVariable String email, @PathVariable String password) {
        return admService.login(email, password);
    }

    @PostMapping
public ResponseEntity<Void> create(@RequestBody Adm adm) {
    System.out.println("Received Adm: " + adm.getEmail() + ", " + adm.getPassword());
    admService.create(adm);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
               .path("/{id}").buildAndExpand(adm.getId_adm()).toUri();
    return ResponseEntity.created(uri).build();
}


    
}