package com.juniorsfredo.xtreme_management_api.api.controllers;

import com.juniorsfredo.xtreme_management_api.api.DTO.avaliacao.request.AvaliacaoRequestDTO;
import com.juniorsfredo.xtreme_management_api.api.DTO.avaliacao.response.AvaliacaoIdDTO;
import com.juniorsfredo.xtreme_management_api.api.DTO.avaliacao.response.AvaliacaoResponseDTO;
import com.juniorsfredo.xtreme_management_api.domain.services.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping("/alunos/{alunoId}")
    public ResponseEntity<List<AvaliacaoResponseDTO>> getAvaliacoesByAlunoId(@PathVariable Long alunoId) {
        List<AvaliacaoResponseDTO> avaliacoes = avaliacaoService.getUltimas2AvaliacoesByAlunoId(alunoId);
        return ResponseEntity.ok(avaliacoes);
    }

    @GetMapping("/alunos/{alunoId}/detalhes")
    public ResponseEntity<List<AvaliacaoResponseDTO>> getAllAvaliacoesByAlunoId(@PathVariable Long alunoId) {
        List<AvaliacaoResponseDTO> avaliacoes = this.avaliacaoService.getAllAvaliacoesByAlunoId(alunoId);
        return ResponseEntity.ok(avaliacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoResponseDTO> getAvaliacaoById(@PathVariable Long id) {
        AvaliacaoResponseDTO avaliacao = avaliacaoService.getAvaliacaoById(id);
        return ResponseEntity.ok(avaliacao);
    }

    @PostMapping("/requisitar-avaliacao")
    public ResponseEntity<AvaliacaoIdDTO> requisitarAvaliacao(@RequestBody AvaliacaoRequestDTO avaliacaoRequest, UriComponentsBuilder uriComponentsBuilder) {
        AvaliacaoIdDTO avaliacao = avaliacaoService.requisitarAvaliacao(avaliacaoRequest);

        URI uri = uriComponentsBuilder.path("/avaliacoes/{id}")
                    .buildAndExpand(avaliacao.id())
                    .toUri();

        return ResponseEntity.created(uri).body(avaliacao);
    }
}
