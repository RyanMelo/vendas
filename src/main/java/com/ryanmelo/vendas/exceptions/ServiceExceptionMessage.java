package com.ryanmelo.vendas.exceptions;

public class ServiceExceptionMessage extends RuntimeException {
    public ServiceExceptionMessage(String message) {
        super(message);
    }
}
