package com.ryanmelo.vendas.controllers;

import org.springframework.http.ResponseEntity;
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

}
