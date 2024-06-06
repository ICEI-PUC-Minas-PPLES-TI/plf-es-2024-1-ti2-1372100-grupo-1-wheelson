package com.renatomatos.wheelson.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.renatomatos.wheelson.services.EmailService;
import com.renatomatos.wheelson.util.Email;


import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/send-email")
public class EmailTestingController {
    
    @Autowired
    private EmailService emailService;

    @GetMapping
    public String sendEmailTest( @RequestBody Email email) {
        
        System.out.println("Email: " + email.getTo() + " - " + email.getSubject() + " - " + email.getBody());
        if (email == null || email.getTo() == null || email.getSubject() == null || email.getBody() == null) {
            return "Erro: Parâmetros de e-mail inválidos";
        }

        emailService.sendEmail(email.getTo(), email.getSubject(), email.getBody());
        return "Email enviado com sucesso";
    }
}
