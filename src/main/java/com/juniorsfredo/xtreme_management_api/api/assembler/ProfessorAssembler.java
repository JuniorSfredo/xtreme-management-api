package com.juniorsfredo.xtreme_management_api.api.assembler;

import com.juniorsfredo.xtreme_management_api.api.DTO.professor.ProfessorResponseDTO;
import com.juniorsfredo.xtreme_management_api.domain.models.Professor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfessorAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ProfessorResponseDTO toDTO(Professor professor) {
        return modelMapper.map(professor, ProfessorResponseDTO.class);
    }

    public List<ProfessorResponseDTO> toListDTO(List<Professor> professores) {
        List<ProfessorResponseDTO> responseDTO = new ArrayList<>();
        professores.forEach(professor -> {
            responseDTO.add(toDTO(professor));
        });
        return responseDTO;
    }
}
