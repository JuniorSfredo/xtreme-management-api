package com.juniorsfredo.xtreme_management_api.domain.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class AlunoNaoEncontradoException extends EntityNotFoundException {

    public AlunoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
