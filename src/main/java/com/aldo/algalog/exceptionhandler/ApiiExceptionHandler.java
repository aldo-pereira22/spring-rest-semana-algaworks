package com.aldo.algalog.exceptionhandler;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiiExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected @NotNull ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Problema.Campo> campos =  new ArrayList<>();
        for(ObjectError erro : ex.getBindingResult().getAllErrors()){
            String nome = ((FieldError) erro).getField();
            String mensagem = erro.getDefaultMessage();
            campos.add(new Problema.Campo(nome, mensagem));
        }
        Problema problema = new Problema();
        problema.setStatus(status.value());
        problema.setTitulo("Um ou mais campos estão inválidos");
        problema.setCampos(campos);

        return handleExceptionInternal(ex, problema, headers, status, request);
    }
}
