package com.meloafc.meeting.mapper;

import com.meloafc.meeting.dto.UsuarioDTO;
import com.meloafc.meeting.model.Usuario;

public class UsuarioMapper implements GenericMapper<Usuario, UsuarioDTO> {

    @Override
    public UsuarioDTO convertToDTO(Usuario entity) {
        return UsuarioDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .cpf(entity.getCpf())
                .build();
    }

    @Override
    public Usuario convertToEntity(UsuarioDTO dto) {
        return Usuario.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .build();
    }
}
