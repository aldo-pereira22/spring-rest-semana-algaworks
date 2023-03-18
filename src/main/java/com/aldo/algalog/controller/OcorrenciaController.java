package com.aldo.algalog.controller;

import com.aldo.algalog.dto.OcorrenciaDto;
import com.aldo.algalog.dto.input.OcorrenciaInput;
import com.aldo.algalog.mapper.OcorrenciaMapper;
import com.aldo.algalog.model.Entrega;
import com.aldo.algalog.model.Ocorrencia;
import com.aldo.algalog.service.BuscaEntregaService;
import com.aldo.algalog.service.RegistroOcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private RegistroOcorrenciaService registroOcorrenciaService;

    @Autowired
    private BuscaEntregaService buscaEntregaService;

    @Autowired
    private OcorrenciaMapper ocorrenciaMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaDto registrar(@PathVariable  Long entregaId,
                                   @Valid @RequestBody OcorrenciaInput ocorrenciaInput){

       Ocorrencia ocorrenciaRegistrada =  registroOcorrenciaService
               .registrar(entregaId, ocorrenciaInput.getDescricao());

        return  ocorrenciaMapper.toModel(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrenciaDto> listar( @PathVariable Long entregaId){
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return ocorrenciaMapper.toCollectionModel(entrega.getOcorrencias());
    }
}
