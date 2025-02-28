package com.juniorsfredo.xtreme_management_api.api.assembler;

import com.juniorsfredo.xtreme_management_api.api.DTO.treino.TreinoResponseDTO;
import com.juniorsfredo.xtreme_management_api.domain.models.Exercicio;
import com.juniorsfredo.xtreme_management_api.domain.models.Treino;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TreinoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public TreinoResponseDTO toResponseDTO(Treino treino, List<Exercicio> exercicios) {
        TreinoResponseDTO response = modelMapper.map(treino, TreinoResponseDTO.class);
        response.setExercicios(exercicios);
        return response;
    }

    public List<TreinoResponseDTO> toListResponseDTO(List<Treino> treinos) {
        return treinos.stream()
                .map(treino -> toResponseDTO(treino, treino.getExercicios()))
                .collect(Collectors.toList());
    }
}
