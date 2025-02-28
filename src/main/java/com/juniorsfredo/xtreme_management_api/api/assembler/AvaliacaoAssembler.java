package com.juniorsfredo.xtreme_management_api.api.assembler;

import com.juniorsfredo.xtreme_management_api.api.DTO.avaliacao.AvaliacaoResponseDTO;
import com.juniorsfredo.xtreme_management_api.domain.models.Avaliacao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AvaliacaoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public AvaliacaoResponseDTO toDTO(Avaliacao avaliacao) {
        return modelMapper.map(avaliacao, AvaliacaoResponseDTO.class);
    }

    public List<AvaliacaoResponseDTO> toListDTO(List<Avaliacao> avaliacoes) {
        return avaliacoes.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
