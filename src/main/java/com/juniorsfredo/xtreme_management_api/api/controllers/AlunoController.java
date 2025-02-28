package com.juniorsfredo.xtreme_management_api.api.controllers;

import com.juniorsfredo.xtreme_management_api.api.DTO.aluno.AlunoIdDTO;
import com.juniorsfredo.xtreme_management_api.api.DTO.aluno.AlunoResponseDTO;
import com.juniorsfredo.xtreme_management_api.api.DTO.aluno.AlunoUpdateBody;
import com.juniorsfredo.xtreme_management_api.api.DTO.treino.TreinoResponseDTO;
import com.juniorsfredo.xtreme_management_api.domain.models.Aluno;
import com.juniorsfredo.xtreme_management_api.domain.models.Treino;
import com.juniorsfredo.xtreme_management_api.domain.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> getAlunoById (@PathVariable Long id) {
        AlunoResponseDTO aluno = alunoService.getAlunoById(id);
        return ResponseEntity.ok(aluno);
    }

    @GetMapping("/{id}/treinos")
    public ResponseEntity<List<TreinoResponseDTO>> getTreinosByAlunoId(@PathVariable Long id) {
        List<TreinoResponseDTO> treinos = alunoService.getTreinosByAlunoId(id);
        return ResponseEntity.ok(treinos);
    }

    @GetMapping("/{alunoId}/treinos/{treinoId}")
    public ResponseEntity<TreinoResponseDTO> getTreinoById(@PathVariable Long alunoId, @PathVariable Long treinoId) {
        TreinoResponseDTO treinoResponse = alunoService.getExerciciosByTreinoId(alunoId, treinoId);
        return ResponseEntity.ok(treinoResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoIdDTO> atualizarDadosAluno(@PathVariable Long id, @RequestBody AlunoUpdateBody novoAluno) {
        AlunoIdDTO aluno = alunoService.atualizarAluno(id, novoAluno);
        return ResponseEntity.ok(aluno);
    }
}
