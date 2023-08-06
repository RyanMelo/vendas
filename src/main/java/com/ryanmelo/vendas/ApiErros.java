package com.ryanmelo.vendas;

import java.util.Arrays;
import java.util.List;

public class ApiErros {
    
    List<String> error;

    public List<String> getError() {
        return error;
    }

    public ApiErros(String messagem) {
        this.error = Arrays.asList(messagem);
    }

}
