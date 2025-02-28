package com.juniorsfredo.xtreme_management_api.domain.services;

import com.juniorsfredo.xtreme_management_api.api.DTO.treino.TreinoResponseDTO;
import com.juniorsfredo.xtreme_management_api.api.assembler.TreinoAssembler;
import com.juniorsfredo.xtreme_management_api.domain.exceptions.TreinoNaoEncontradoException;
import com.juniorsfredo.xtreme_management_api.domain.models.Exercicio;
import com.juniorsfredo.xtreme_management_api.domain.models.Treino;
import com.juniorsfredo.xtreme_management_api.domain.repositories.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository treinoRepository;

    @Autowired
    private ExercicioService exercicioService;

    @Autowired
    private TreinoAssembler treinoAssembler;

    public List<TreinoResponseDTO> getTreinosByAlunoId(Long alunoId) {
        List<Treino> treinos = treinoRepository.findTreinosByAlunoId(alunoId);
        return treinoAssembler.toListResponseDTO(treinos);
    }

    public TreinoResponseDTO getTreinoById(Long id) {
        Treino treino = this.findTreinoById(id);
        List<Exercicio> exercicios = exercicioService.getExerciciosByTreinoId(id);
        return treinoAssembler.toResponseDTO(treino, exercicios);
    }

    private Treino findTreinoById(Long id) {
        return treinoRepository.findById(id)
                .orElseThrow( () -> new TreinoNaoEncontradoException("Treino com id: " + id + " não encontrado"));
    }
}
