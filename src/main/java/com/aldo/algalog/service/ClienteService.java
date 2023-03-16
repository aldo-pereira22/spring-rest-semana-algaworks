package com.aldo.algalog.service;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aldo.algalog.exception.NegocioException;
import com.aldo.algalog.model.Cliente;
import com.aldo.algalog.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteService {
	
	private ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		
		System.out.println("\n\n\n\n\n\nCLIENTE" + cliente);
			boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
					.stream()
					.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
			
			if(emailEmUso) {
				throw new NegocioException("Ja existe um cliente cadastrado com este email");
			}
			return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
}













