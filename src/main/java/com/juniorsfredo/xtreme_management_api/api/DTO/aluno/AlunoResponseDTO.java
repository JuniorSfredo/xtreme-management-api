package com.juniorsfredo.xtreme_management_api.api.DTO.aluno;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AlunoResponseDTO {

    private Integer id;
    private String nome;
    private String cpf;
    private Double altura;
    private Double peso;
    private LocalDate dataNascimento;
    private Boolean ativo;
    private String endereco;
}
