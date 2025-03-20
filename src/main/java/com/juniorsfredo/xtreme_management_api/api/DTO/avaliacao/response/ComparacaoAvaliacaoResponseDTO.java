package com.juniorsfredo.xtreme_management_api.api.DTO.avaliacao.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComparacaoAvaliacaoResponseDTO {

    private Integer minPercentualGordura;
    private Integer maxPercentualGordura;
    private Integer minPeso;
    private Integer maxPeso;
}
