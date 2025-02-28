package com.juniorsfredo.xtreme_management_api.api.DTO.mensalidade;

import com.juniorsfredo.xtreme_management_api.api.DTO.mensalidade.refs.AlunoRefDTO;
import com.juniorsfredo.xtreme_management_api.api.DTO.mensalidade.refs.PlanoRefDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MensalidadeResponseDTO {

    private Long id;
    private LocalDate dataVencimento;
    private String statusPagamento;
    private PlanoRefDTO plano;
    private AlunoRefDTO aluno;
}
