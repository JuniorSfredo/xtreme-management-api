package com.juniorsfredo.xtreme_management_api.domain.services;

import com.juniorsfredo.xtreme_management_api.api.DTO.avaliacao.AvaliacaoResponseDTO;
import com.juniorsfredo.xtreme_management_api.api.assembler.AvaliacaoAssembler;
import com.juniorsfredo.xtreme_management_api.domain.exceptions.AvaliacaoNaoEncontrada;
import com.juniorsfredo.xtreme_management_api.domain.models.Avaliacao;
import com.juniorsfredo.xtreme_management_api.domain.repositories.AvalicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvalicaoRepository avaliacaoRepository;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private AvaliacaoAssembler avaliacaoAssembler;

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

    public Avaliacao findAvaliacaoById(Long id) {
        return avaliacaoRepository.findById(id)
                .orElseThrow( () -> new AvaliacaoNaoEncontrada("Avaliacao com id: " + id + "não encontrada"));
    }
}
