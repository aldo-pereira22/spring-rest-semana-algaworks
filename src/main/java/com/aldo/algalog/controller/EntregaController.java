package com.aldo.algalog.controller;

import com.aldo.algalog.model.Entrega;
import com.aldo.algalog.repository.EntregaRepository;
import com.aldo.algalog.service.SolicitacaoEntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private SolicitacaoEntregaService solicitacaoEntregaService;

    @Autowired
    EntregaRepository entregaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar (@Valid @RequestBody  Entrega entrega){
        return solicitacaoEntregaService.solicitar(entrega);
    }

    @GetMapping
    public List<Entrega> listar(){
        return entregaRepository.findAll();
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<Entrega> buscar(@PathVariable Long entregaId){
        return entregaRepository.findById(entregaId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}