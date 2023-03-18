package com.aldo.algalog.service;

import com.aldo.algalog.model.Entrega;
import com.aldo.algalog.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {


    @Autowired
    private BuscaEntregaService buscaEntregaService;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao){
        Entrega entrega = buscaEntregaService.buscar(entregaId);
        Ocorrencia ocorrencia = entrega.adicionarOcorrencia(descricao);
        return ocorrencia;
    }
}
