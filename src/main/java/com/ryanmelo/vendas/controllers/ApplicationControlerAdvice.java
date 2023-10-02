package com.ryanmelo.vendas.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ryanmelo.vendas.ApiErros;
import com.ryanmelo.vendas.exceptions.ServiceExceptionMessage;


@RestControllerAdvice
public class ApplicationControlerAdvice {
    
    @ExceptionHandler(ServiceExceptionMessage.class)
    public ResponseEntity<ApiErros> handleRegraNoegocioException(ServiceExceptionMessage ex) {
        String mensagemError = ex.getMessage();
        return ResponseEntity.badRequest().body(new ApiErros(mensagemError));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErros> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getAllErrors()
            .stream()
            .map(e -> e.getDefaultMessage())
            .collect(Collectors.toList());
            
        return ResponseEntity.badRequest().body(new ApiErros(errors));
    }

}
