package com.aldo.algalog.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class NegocioException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	 
	public NegocioException(String mensagem) {
		super(mensagem);
	}
}
