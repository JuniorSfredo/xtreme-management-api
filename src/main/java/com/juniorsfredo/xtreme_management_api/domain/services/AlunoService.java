package com.juniorsfredo.xtreme_management_api.domain.services;

import com.juniorsfredo.xtreme_management_api.api.DTO.aluno.AlunoIdDTO;
import com.juniorsfredo.xtreme_management_api.api.DTO.aluno.AlunoResponseDTO;
import com.juniorsfredo.xtreme_management_api.api.DTO.aluno.AlunoUpdateBody;
import com.juniorsfredo.xtreme_management_api.api.DTO.treino.TreinoResponseDTO;
import com.juniorsfredo.xtreme_management_api.api.assembler.AlunoAssembler;
import com.juniorsfredo.xtreme_management_api.domain.exceptions.AlunoNaoEncontradoException;
import com.juniorsfredo.xtreme_management_api.domain.models.Aluno;
import com.juniorsfredo.xtreme_management_api.domain.repositories.AlunoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TreinoService treinoService;

    @Autowired
    private AlunoAssembler alunoAssembler;

    public AlunoResponseDTO getAlunoById(Long id) {
        Aluno aluno = this.findAlunoById(id);
        return alunoAssembler.toAlunoResponseDTO(aluno);
    }

    public List<TreinoResponseDTO> getTreinosByAlunoId (Long id) {
        this.findAlunoById(id);
        return treinoService.getTreinosByAlunoId(id);
    }

    public TreinoResponseDTO getExerciciosByTreinoId(Long alunoId, Long treinoId) {
        Aluno aluno = this.findAlunoById(alunoId);
        return treinoService.getTreinoById(treinoId);
    }

    public AlunoIdDTO atualizarAluno(Long id, AlunoUpdateBody novoAluno) {
        Aluno aluno = this.findAlunoById(id);
        aluno = this.atualizarDados(aluno, novoAluno);
        return new AlunoIdDTO(aluno.getId());
    }

    public Aluno salvarAluno(Aluno aluno) {
        try {
            return alunoRepository.save(aluno);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private Aluno atualizarDados(Aluno aluno, AlunoUpdateBody novoAluno) {
        BeanUtils.copyProperties(novoAluno, aluno, "id", "treinos", "avaliacoes", "mensalidades");
        return alunoRepository.save(aluno);
    }

    public Aluno findAlunoById (Long id) {
        return alunoRepository.findById(id)
                .orElseThrow( () -> new AlunoNaoEncontradoException("Aluno com id: " + id + "não encontrado!"));
    }
}
