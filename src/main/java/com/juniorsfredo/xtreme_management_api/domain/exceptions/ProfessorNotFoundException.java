package com.juniorsfredo.xtreme_management_api.domain.exceptions;

public class ProfessorNotFoundException extends EntityNotFoundException{

    public ProfessorNotFoundException(String mensagem) {
        super(mensagem);
    }
}
