package com.meloafc.meeting.controller;

import com.meloafc.meeting.dto.*;
import com.meloafc.meeting.exception.NotFoundException;
import com.meloafc.meeting.mapper.UsuarioMapper;
import com.meloafc.meeting.model.Usuario;
import com.meloafc.meeting.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    private final UsuarioMapper usuarioMapper = new UsuarioMapper();

    @GetMapping()
    @ApiOperation(value = "Listar todos os Usuários")
    public List<UsuarioDTO> getAll() {
        return usuarioMapper.convertToListDTO(usuarioService.find());
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Consultar Usuário por id")
    public UsuarioDTO findById(@ApiParam(value = "id", required = true) @PathVariable Long id) throws NotFoundException {
        return usuarioMapper.convertToDTO(usuarioService.findOne(id));
    }

    @PostMapping()
    @ApiOperation(value = "Salvar novo Usuário")
    public UsuarioDTO add(@RequestBody CpfNomeDTO dto) {
        Usuario usuario = usuarioService.add(Usuario.builder()
                .cpf(dto.getCpf())
                .nome(dto.getNome())
                .build());
        return usuarioMapper.convertToDTO(usuario);
    }

}
