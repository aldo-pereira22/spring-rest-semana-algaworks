package com.aldo.algalog.controller;

import com.aldo.algalog.dto.DestinatarioDto;
import com.aldo.algalog.dto.EntregaDto;
import com.aldo.algalog.dto.input.EntregaIput;
import com.aldo.algalog.mapper.EntregaMapper;
import com.aldo.algalog.model.Entrega;
import com.aldo.algalog.repository.EntregaRepository;
import com.aldo.algalog.service.FinalizacaoEntregaService;
import com.aldo.algalog.service.SolicitacaoEntregaService;
import org.modelmapper.ModelMapper;
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
    private FinalizacaoEntregaService finalizacaoEntregaService;

    @Autowired
    EntregaRepository entregaRepository;

    @Autowired
    private EntregaMapper entregaMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaDto solicitar (@Valid @RequestBody EntregaIput entregaInput){
        Entrega novaEntrega = entregaMapper.toEntity(entregaInput);
        Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);
        return entregaMapper.toModel(entregaSolicitada);
    }

    @GetMapping
    public List<EntregaDto> listar(){
        return entregaMapper.toCollectionModel(entregaRepository.findAll());
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaDto> buscar(@PathVariable Long entregaId){
        return entregaRepository.findById(entregaId)
                .map( entrega -> {
                    EntregaDto entregaDto = entregaMapper.toModel(entrega);
                  return ResponseEntity.ok(entregaDto);
                }).orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{entregaId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long entregaId){
        finalizacaoEntregaService.finalizar(entregaId);
    }
}
