package com.juniorsfredo.xtreme_management_api.api.assembler;

import com.juniorsfredo.xtreme_management_api.api.DTO.mensalidade.MensalidadeResponseDTO;
import com.juniorsfredo.xtreme_management_api.domain.models.Mensalidade;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MensalidadeAssembler {

    @Autowired
    private ModelMapper mapper;

    public MensalidadeResponseDTO toDTO(Mensalidade mensalidade) {
        return mapper.map(mensalidade, MensalidadeResponseDTO.class);
    }

    public List<MensalidadeResponseDTO> toListDTO(List<Mensalidade> mensalidades) {
        List<MensalidadeResponseDTO> mensalidadeResponseDTO = new ArrayList<>();
        mensalidades.forEach( mensalidade -> {
            mensalidadeResponseDTO.add(toDTO(mensalidade));
        });
        return mensalidadeResponseDTO;
    }
}
