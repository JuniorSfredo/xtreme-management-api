package com.juniorsfredo.xtreme_management_api.api.DTO.aluno;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AlunoUpdateBody {

    private String nome;

    private Integer cpf;

    private Double altura;

    private Double peso;

    private LocalDate dataNascimento;

    private String endereco;

    private Boolean ativo;
}
