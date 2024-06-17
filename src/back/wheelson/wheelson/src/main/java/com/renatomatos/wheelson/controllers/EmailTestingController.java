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

    
    @GetMapping("/test/{nomeSacado}/{cpfSacado}/{valorAluguel}")
    public String sendEmailTest( @RequestBody Email email, @PathVariable String nomeSacado, @PathVariable String cpfSacado, @PathVariable double valorAluguel) {
        
        System.out.println("Email: " + email.getTo() + " - " + email.getSubject() + " - " + email.getBody());
        System.out.println("Nome: " + nomeSacado + " - CPF: " + cpfSacado + " - Valor: " + valorAluguel);
        if (email == null || email.getTo() == null || email.getSubject() == null || email.getBody() == null) {
            return "Erro: Parâmetros de e-mail inválidos";
        }
        if (email.getTo().isEmpty() || email.getSubject().isEmpty() || email.getBody().isEmpty()) {
            return "Erro: Parâmetros de e-mail vazios";
        }
        if (nomeSacado == null || cpfSacado == null) {
            return "Erro: Parâmetros de boleto inválidos";
        }
        if (nomeSacado.isEmpty() || cpfSacado.isEmpty()) {
            return "Erro: Parâmetros de boleto vazios";
        }


        emailService.sendEmail(email, nomeSacado, cpfSacado, valorAluguel);
        return "Email enviado com sucesso";
    }
}
