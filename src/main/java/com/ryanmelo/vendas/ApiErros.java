package com.ryanmelo.vendas;

import java.util.Arrays;
import java.util.List;

public class ApiErros {
    
    List<String> error;

    public ApiErros(String messagem) {
        this.error = Arrays.asList(messagem);
    }

    public ApiErros(List<String> messagem) {
        this.error = messagem;
    }

    public List<String> getError() {
        return error;
    }

}
