package com.juniorsfredo.xtreme_management_api.domain.exceptions;

public class TreinoNaoEncontradoException extends EntityNotFoundException{

    public TreinoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
