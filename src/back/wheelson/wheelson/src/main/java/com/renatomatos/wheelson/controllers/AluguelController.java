package com.renatomatos.wheelson.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.renatomatos.wheelson.models.Aluguel;
import com.renatomatos.wheelson.services.AluguelService;

public class AluguelController {
    @Autowired
    private AluguelService aluguelService;


    //Método para atualizar um aluguel parcialmente, seja o status de pagamento, ativo ou valor total
    @PatchMapping("/{id}")
    public Aluguel patchAluguel(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return aluguelService.updatePartial(id, updates);
    }
}
