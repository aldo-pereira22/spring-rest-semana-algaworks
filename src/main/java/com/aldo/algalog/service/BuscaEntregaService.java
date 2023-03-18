package com.aldo.algalog.service;

import com.aldo.algalog.exception.EntidadeNaoEncontradaException;
import com.aldo.algalog.exception.NegocioException;
import com.aldo.algalog.model.Entrega;
import com.aldo.algalog.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId) {
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
    }
}
