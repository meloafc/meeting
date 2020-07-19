package com.meloafc.meeting.mapper;

import com.meloafc.meeting.dto.PautaDTO;
import com.meloafc.meeting.model.Pauta;

public class PautaMapper implements GenericMapper<Pauta, PautaDTO> {

    @Override
    public PautaDTO convertToDTO(Pauta entity) {
        return PautaDTO.builder()
                .id(entity.getId())
                .assunto(entity.getAssunto())
                .status(entity.getStatus())
                .build();
    }

    @Override
    public Pauta convertToEntity(PautaDTO dto) {
        return Pauta.builder()
                .id(dto.getId())
                .build();
    }

}
