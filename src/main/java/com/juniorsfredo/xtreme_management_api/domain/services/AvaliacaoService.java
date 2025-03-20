package com.juniorsfredo.xtreme_management_api.domain.services;

import com.juniorsfredo.xtreme_management_api.api.DTO.avaliacao.request.AvaliacaoRequestDTO;
import com.juniorsfredo.xtreme_management_api.api.DTO.avaliacao.response.AvaliacaoIdDTO;
import com.juniorsfredo.xtreme_management_api.api.DTO.avaliacao.response.AvaliacaoResponseDTO;
import com.juniorsfredo.xtreme_management_api.api.assembler.AvaliacaoAssembler;
import com.juniorsfredo.xtreme_management_api.domain.exceptions.AvaliacaoNaoEncontrada;
import com.juniorsfredo.xtreme_management_api.domain.exceptions.DataNaoDisponivelException;
import com.juniorsfredo.xtreme_management_api.domain.models.Aluno;
import com.juniorsfredo.xtreme_management_api.domain.models.Avaliacao;
import com.juniorsfredo.xtreme_management_api.domain.models.Professor;
import com.juniorsfredo.xtreme_management_api.domain.models.enums.StatusAvaliacao;
import com.juniorsfredo.xtreme_management_api.domain.repositories.AvalicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvalicaoRepository avaliacaoRepository;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private AvaliacaoAssembler avaliacaoAssembler;

    @Autowired
    private ProfessorService professorService;

    public List<AvaliacaoResponseDTO> getUltimas2AvaliacoesByAlunoId(Long alunoId) {
        this.alunoService.findAlunoById(alunoId);
        List<Avaliacao> avaliacoes = avaliacaoRepository.find2UltimasAvaliacoesByAlunoId(alunoId, PageRequest.of(0, 2));
        return avaliacaoAssembler.toListDTO(avaliacoes);
    }

    public List<AvaliacaoResponseDTO> getAllAvaliacoesByAlunoId(Long alunoId) {
        this.alunoService.findAlunoById(alunoId);
        List<Avaliacao> avaliacoes = avaliacaoRepository.findAvaliacoesByAlunoId(alunoId);
        return avaliacaoAssembler.toListDTO(avaliacoes);
    }

    public AvaliacaoResponseDTO getAvaliacaoById(Long id) {
        Avaliacao avaliacao = this.findAvaliacaoById(id);
        return avaliacaoAssembler.toDTO(avaliacao);
    }

    @Transactional
    public Avaliacao saveAvaliacao(Avaliacao avaliacao) {
        try {
            return this.avaliacaoRepository.save(avaliacao);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não foi possivel salvar a avaliação");
        }
    }

    @Transactional
    public AvaliacaoIdDTO requisitarAvaliacao(AvaliacaoRequestDTO avaliacaoRequest) {
        Aluno aluno = alunoService.findAlunoById(avaliacaoRequest.getAluno().getId());
        Professor professor = professorService.findProfessorById(avaliacaoRequest.getProfessor().getId());
        LocalDateTime data = LocalDateTime.ofInstant(Instant.parse(avaliacaoRequest.getData()),
                                                     ZoneId.of("UTC"));
        if (avaliacaoRepository.existsAvaliacaoBetween2Datas(data.minusMinutes(30), data.plusMinutes(30)).isPresent())
            throw new DataNaoDisponivelException("Essa data não está disponível!");
        
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setAluno(aluno);
        avaliacao.setProfessor(professor);
        avaliacao.setData(data);
        avaliacao.setStatus(StatusAvaliacao.PENDENTE);

        return new AvaliacaoIdDTO(this.saveAvaliacao(avaliacao).getId());
    }

    public Avaliacao findAvaliacaoById(Long id) {
        return avaliacaoRepository.findById(id)
                .orElseThrow( () -> new AvaliacaoNaoEncontrada("Avaliacao com id: " + id + "não encontrada"));
    }
}
