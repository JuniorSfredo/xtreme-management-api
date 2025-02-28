package com.juniorsfredo.xtreme_management_api.api.assembler;

import com.juniorsfredo.xtreme_management_api.api.DTO.aluno.AlunoResponseDTO;
import com.juniorsfredo.xtreme_management_api.domain.models.Aluno;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlunoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public AlunoResponseDTO toAlunoResponseDTO(Aluno aluno) {
        return modelMapper.map(aluno, AlunoResponseDTO.class);
    }
}
