package com.juniorsfredo.xtreme_management_api.domain.exceptions;

public class DataNaoDisponivelException extends RuntimeException{

    public DataNaoDisponivelException(String mensagem) {
        super(mensagem);
    }
}
