package com.aldo.algalog.service;

import com.aldo.algalog.exception.NegocioException;
import com.aldo.algalog.model.Cliente;
import com.aldo.algalog.model.Entrega;
import com.aldo.algalog.model.StatusEntrega;
import com.aldo.algalog.repository.ClienteRepository;
import com.aldo.algalog.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    ClienteService clienteService;

    @Transactional
    public Entrega solicitar(Entrega entrega){

        Cliente cliente = clienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());

        return entregaRepository.save(entrega);
    }
}




