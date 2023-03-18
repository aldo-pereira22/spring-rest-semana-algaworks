package com.aldo.algalog.service;

import com.aldo.algalog.model.Entrega;
import com.aldo.algalog.model.StatusEntrega;
import com.aldo.algalog.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    private BuscaEntregaService buscaEntregaService;



    @Transactional
    public void finalizar(Long entregaId){
        Entrega entrega = buscaEntregaService.buscar(entregaId);
        entrega.finalizar();
        entregaRepository.save(entrega);
    }
}
