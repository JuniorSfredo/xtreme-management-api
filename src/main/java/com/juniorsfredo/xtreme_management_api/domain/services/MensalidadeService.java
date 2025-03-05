package com.juniorsfredo.xtreme_management_api.domain.services;

import com.juniorsfredo.xtreme_management_api.api.DTO.mensalidade.MensalidadeIdDTO;
import com.juniorsfredo.xtreme_management_api.api.DTO.mensalidade.MensalidadeResponseDTO;
import com.juniorsfredo.xtreme_management_api.api.assembler.MensalidadeAssembler;
import com.juniorsfredo.xtreme_management_api.domain.exceptions.MensalidadeNotFoundException;
import com.juniorsfredo.xtreme_management_api.domain.exceptions.MensalidadePagaException;
import com.juniorsfredo.xtreme_management_api.domain.models.Mensalidade;
import com.juniorsfredo.xtreme_management_api.domain.models.enums.StatusPagamento;
import com.juniorsfredo.xtreme_management_api.domain.repositories.MensalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MensalidadeService {

    @Autowired
    private MensalidadeRepository mensalidadeRepository;

    @Autowired
    private MensalidadeAssembler assembler;

    public MensalidadeResponseDTO getMensalidadeById(Long id) {
        Mensalidade mensalidade = this.findMensalidadeById(id);
        return assembler.toDTO(mensalidade);
    }

    public List<MensalidadeResponseDTO> getMensalidadesByAlunoId(Long id) {
        List<Mensalidade> mensalidades = mensalidadeRepository.findMensalidadeByAlunoId(id);
        return assembler.toListDTO(mensalidades);
    }

    @Transactional
    public MensalidadeIdDTO pagarMensalidade(Long id) {
        Mensalidade mensalidade = this.findMensalidadeById(id);
        if (mensalidade.getStatusPagamento() == StatusPagamento.PAGO)
            throw new MensalidadePagaException("Mensalide de id: " + id + " já está paga!");

        mensalidade.setStatusPagamento(StatusPagamento.PAGO);
        return new MensalidadeIdDTO(mensalidadeRepository.save(mensalidade).getId());
    }

    private Mensalidade findMensalidadeById(Long id) {
        return mensalidadeRepository.findById(id)
                .orElseThrow( () -> new MensalidadeNotFoundException("Mensalidade com id: " + id + "não encontrada!"));
    }
}
