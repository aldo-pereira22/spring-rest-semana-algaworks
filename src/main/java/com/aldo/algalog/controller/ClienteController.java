package com.aldo.algalog.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aldo.algalog.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		Cliente cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("João");
		cliente1.setTelefone("628854751212");
		cliente1.setEmail("joão@gmail.com");
		
		Cliente cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Aldo");
		cliente2.setTelefone("628854751212");
		cliente2.setEmail("aldo@gmail.com");
		
		Cliente cliente3 = new Cliente();
		cliente3.setId(3L);
		cliente3.setNome("Zé das couves");
		cliente3.setTelefone("6288547512123334");
		cliente3.setEmail("zé@gmail.com");
		
		return Arrays.asList(cliente1, cliente2, cliente3);
	}
}
