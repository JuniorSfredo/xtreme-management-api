package com.juniorsfredo.xtreme_management_api.domain.services;

import com.juniorsfredo.xtreme_management_api.api.DTO.professor.ProfessorResponseDTO;
import com.juniorsfredo.xtreme_management_api.api.assembler.ProfessorAssembler;
import com.juniorsfredo.xtreme_management_api.domain.models.Professor;
import com.juniorsfredo.xtreme_management_api.domain.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private ProfessorAssembler professorAssembler;

    public List<ProfessorResponseDTO> findAllProfessores() {
        List<Professor> professores = professorRepository.findAll();
        return professorAssembler.toListDTO(professores);
    }
}
