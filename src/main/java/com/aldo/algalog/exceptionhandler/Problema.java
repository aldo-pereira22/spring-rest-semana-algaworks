package com.aldo.algalog.exceptionhandler;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class Problema {
	private Integer status;
	private LocalDate dataHora;
	private String titulo;
	private List<Problema.Campo> campos;
	
	@AllArgsConstructor
	@Getter
	public static class Campo {
		private String campo;
		private String mensagem;
	}
}
