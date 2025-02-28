package com.juniorsfredo.xtreme_management_api.api.controllers;

import com.juniorsfredo.xtreme_management_api.api.DTO.mensalidade.MensalidadeIdDTO;
import com.juniorsfredo.xtreme_management_api.api.DTO.mensalidade.MensalidadeResponseDTO;
import com.juniorsfredo.xtreme_management_api.domain.services.MensalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensalidades")
public class MensalidadeController {

    @Autowired
    private MensalidadeService mensalidadeService;

    @GetMapping("/{id}")
    public ResponseEntity<MensalidadeResponseDTO> getMensalidadeById(@PathVariable Long id) {
        MensalidadeResponseDTO mensalidadeResponseDTO = this.mensalidadeService.getMensalidadeById(id);
        return ResponseEntity.ok(mensalidadeResponseDTO);
    }

    @GetMapping("/alunos/{alunoId}")
    public ResponseEntity<List<MensalidadeResponseDTO>> getMensalidadeByAlunoId(@PathVariable Long alunoId) {
        List<MensalidadeResponseDTO> mensalidades = mensalidadeService.getMensalidadesByAlunoId(alunoId);
        return ResponseEntity.ok(mensalidades);
    }

    @PostMapping("/{id}/pagar")
    public ResponseEntity<MensalidadeIdDTO> pagarMensalidade(@PathVariable Long id) {
        MensalidadeIdDTO mensalidade = mensalidadeService.pagarMensalidade(id);
        return ResponseEntity.ok(mensalidade);
    }
}
