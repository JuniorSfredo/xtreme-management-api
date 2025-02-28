package com.juniorsfredo.xtreme_management_api.domain.exceptions;

public class MensalidadeNotFoundException extends EntityNotFoundException{

    public MensalidadeNotFoundException(String mensagem) {
        super(mensagem);
    }
}
