package com.juniorsfredo.xtreme_management_api.domain.exceptions;

public class AvaliacaoNaoEncontrada extends EntityNotFoundException {

    public AvaliacaoNaoEncontrada(String mensagem) {
        super(mensagem);
    }
}
