package com.renatomatos.wheelson.controllers;

import java.net.URI;
import java.util.Map;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renatomatos.wheelson.models.Aluguel;
import com.renatomatos.wheelson.services.AluguelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/aluguel")
@Validated
public class AluguelController {
    @Autowired
    private AluguelService aluguelService;


    @GetMapping("/{id}")
    public ResponseEntity<Aluguel> findById(@PathVariable Long id) {
        Aluguel aluguel = this.aluguelService.findById(id);
        return ResponseEntity.ok().body(aluguel);
    }

    //Método para atualizar um aluguel por completo
    @PostMapping
    public ResponseEntity<Void> create( @RequestBody @Valid Aluguel aluguel) {
        this.aluguelService.create(aluguel);
                 URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(aluguel.getId_aluguel()).toUri() ;
         return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.aluguelService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //Método para atualizar um aluguel parcialmente, seja o status de pagamento, ativo ou valor total
    @PatchMapping("/{id}")
    public Aluguel patchAluguel(@PathVariable Long id, @RequestBody @Valid Map<String, Object> updates) {
        return aluguelService.updatePartial(id, updates);
    }

    @GetMapping("/alugueis")
    public ResponseEntity<List<Aluguel>> findAll() {
        List<Aluguel> alugueis = this.aluguelService.findAll();
        return ResponseEntity.ok().body(alugueis);
    }

    @GetMapping("/alugueis/locador/{id}")
    public ResponseEntity<List<Aluguel>> findByLocadorId(@PathVariable Long id) {
        List<Aluguel> alugueis = this.aluguelService.findByLocadorId(id);
        return ResponseEntity.ok().body(alugueis);
    }

    @GetMapping("/alugueis/locatario/{id}")
    public ResponseEntity<List<Aluguel>> findByLocatarioId(@PathVariable Long id) {
        List<Aluguel> alugueis = this.aluguelService.findByLocatarioId(id);
        return ResponseEntity.ok().body(alugueis);
    }

    @GetMapping("/alugueis/carro/{id}")
    public ResponseEntity<List<Aluguel>> findByCarroId(@PathVariable Long id) {
        List<Aluguel> alugueis = this.aluguelService.findByCarroId(id);
        return ResponseEntity.ok().body(alugueis);
    }

    //finalizar o aluguel e atualizar o status de pagamento e atribuir saldo ao locador
    // Método para finalizar o aluguel
    @PatchMapping("/finalizar/{id}")
    public ResponseEntity<Aluguel> finalizarAluguel(@PathVariable Long id) {
        Aluguel aluguelFinalizado = aluguelService.finalizarAluguel(id);
        return ResponseEntity.ok().body(aluguelFinalizado);
    }

    @GetMapping("/taxa-mensal")
    public ResponseEntity<Map<Integer, Double>> getMonthlyBookingRates() {
        Map<Integer, Double> monthlyRates = aluguelService.getMonthlyBookingRates();
        return ResponseEntity.ok().body(monthlyRates);
    }
}
