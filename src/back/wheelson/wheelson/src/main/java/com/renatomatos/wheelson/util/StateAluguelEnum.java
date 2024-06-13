package com.renatomatos.wheelson.util;

public enum StateAluguelEnum {
    ATIVO("Ativo"), FINALIZADO("Finalizado"), EM_DEVOLUCAO("Em devolução");

    private String state;

    StateAluguelEnum(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
    
}
