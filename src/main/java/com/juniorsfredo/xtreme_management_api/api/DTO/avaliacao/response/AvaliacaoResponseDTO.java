package com.juniorsfredo.xtreme_management_api.api.DTO.avaliacao.response;

import com.juniorsfredo.xtreme_management_api.api.DTO.avaliacao.refs.AlunoRefDTO;
import com.juniorsfredo.xtreme_management_api.api.DTO.avaliacao.refs.DobraCutaneaRefDTO;
import com.juniorsfredo.xtreme_management_api.api.DTO.avaliacao.refs.ProfessorResponseRefDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class AvaliacaoResponseDTO {

    private Long id;

    private String status;

    private LocalDateTime data;

    private Double peso;

    private Double percentualDeGordura;

    private Double imc;

    private String observacao;

    private AlunoRefDTO aluno;

    private ProfessorResponseRefDTO professor;

    private List<DobraCutaneaRefDTO> dobrasCutaneas;

}
