package com.juniorsfredo.xtreme_management_api.api.DTO.treino;

import com.juniorsfredo.xtreme_management_api.api.DTO.treino.refs.AlunoRefDTO;
import com.juniorsfredo.xtreme_management_api.api.DTO.treino.refs.ProfessorResponseRefDTO;
import com.juniorsfredo.xtreme_management_api.domain.models.Exercicio;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TreinoResponseDTO {

    private Integer id;

    private String nome;

    private AlunoRefDTO aluno;

    private ProfessorResponseRefDTO professor;

    private List<Exercicio> exercicios = new ArrayList<>();
}
