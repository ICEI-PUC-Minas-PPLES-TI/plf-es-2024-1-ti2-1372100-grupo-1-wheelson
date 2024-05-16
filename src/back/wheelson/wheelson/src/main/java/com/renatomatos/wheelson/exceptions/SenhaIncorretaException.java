package com.renatomatos.wheelson.exceptions;

public class SenhaIncorretaException extends RuntimeException{
    public SenhaIncorretaException() {
        super("Senha incorreta");
    }
    
}
