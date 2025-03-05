package com.juniorsfredo.xtreme_management_api.api.controllers;

import com.juniorsfredo.xtreme_management_api.api.DTO.professor.ProfessorResponseDTO;
import com.juniorsfredo.xtreme_management_api.domain.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDTO>> getAllProfessores() {
        List<ProfessorResponseDTO> professorResponseDTO = professorService.findAllProfessores();
        return ResponseEntity.ok(professorResponseDTO);
    }
}
