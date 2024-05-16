package com.renatomatos.wheelson.exceptions;

public class EmailNotFoundException extends RuntimeException{
    public EmailNotFoundException(String email) {
        super("Email: " + email + " não encontrado no sistema.");
    } 
    
}
