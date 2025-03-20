package com.juniorsfredo.xtreme_management_api.api.DTO.avaliacao.request;

import com.juniorsfredo.xtreme_management_api.api.DTO.avaliacao.refs.AlunoRefDTO;
import com.juniorsfredo.xtreme_management_api.api.DTO.avaliacao.refs.ProfessorRequestRefDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvaliacaoRequestDTO {

    private String data;

    private AlunoRefDTO aluno;

    private ProfessorRequestRefDTO professor;
}
