package com.aldo.algalog.controller;

import com.aldo.algalog.dto.DestinatarioDto;
import com.aldo.algalog.dto.EntregaDto;
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
    public ResponseEntity<EntregaDto> buscar(@PathVariable Long entregaId){
        return entregaRepository.findById(entregaId)
                .map( entrega -> {
                  EntregaDto entregaDto = new EntregaDto();
                  entregaDto.setId(entrega.getId());
                  entregaDto.setNomeCliente(entrega.getCliente().getNome());
                  entregaDto.setDestinatarioDto(new DestinatarioDto());
                  entregaDto.getDestinatarioDto().setNome(entrega.getDestinatario().getNome());
                  entregaDto.getDestinatarioDto().setLogradouro(entrega.getDestinatario().getLogradouro());
                  entregaDto.getDestinatarioDto().setNumero(entrega.getDestinatario().getNumero());
                  entregaDto.getDestinatarioDto().setComplemento(entrega.getDestinatario().getComplemento());
                  entregaDto.getDestinatarioDto().setBairro(entrega.getDestinatario().getBairro());
                  entregaDto.setTaxa(entrega.getTaxa());
                  entregaDto.setStatus(entrega.getStatus());
                  entregaDto.setDataPedido(entrega.getDataPedido());
                  entregaDto.setDataFinalizacao(entrega.getDataFinalizacao());
                  return ResponseEntity.ok(entregaDto);
                }).orElse(ResponseEntity.notFound().build());
    }
}
