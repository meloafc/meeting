package com.meloafc.meeting.controller;

import com.meloafc.meeting.dto.AssuntoDTO;
import com.meloafc.meeting.dto.PautaDTO;
import com.meloafc.meeting.dto.PautaSessaoDTO;
import com.meloafc.meeting.dto.PautaVotoDTO;
import com.meloafc.meeting.exception.NotFoundException;
import com.meloafc.meeting.mapper.PautaMapper;
import com.meloafc.meeting.model.Pauta;
import com.meloafc.meeting.service.PautaService;
import com.meloafc.meeting.service.VotoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/pautas")
public class PautaController {

    @Autowired
    PautaService pautaService;

    @Autowired
    VotoService votoService;

    private final PautaMapper pautaMapper = new PautaMapper();

    @GetMapping()
    @ApiOperation(value = "Listar todas as Pautas")
    public List<PautaDTO> getAll() {
        return pautaMapper.convertToListDTO(pautaService.find());
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Consultar Pauta por id")
    public PautaDTO findById(@ApiParam(value = "id", required = true) @PathVariable Long id) throws NotFoundException {
        return pautaMapper.convertToDTO(pautaService.findOne(id));
    }

    @GetMapping(value = "/{id}/votos")
    @ApiOperation(value = "Contabilizar votos")
    public PautaVotoDTO cotabilizarVotos(@ApiParam(value = "id", required = true) @PathVariable Long id) throws NotFoundException {
        PautaVotoDTO dto = pautaMapper.convertToVotoDTO(pautaService.findOne(id));
        dto.setVotosSim(votoService.countByPauta(dto.getId(), true));
        dto.setVotosNao(votoService.countByPauta(dto.getId(), false));
        return dto;
    }

    @PostMapping()
    @ApiOperation(value = "Criar nova Pauta")
    public PautaDTO novaPauta(@RequestBody AssuntoDTO dto) {
        Pauta pauta = pautaService.add(Pauta.builder().assunto(dto.getAssunto()).build());
        return pautaMapper.convertToDTO(pauta);
    }

    @PostMapping("abrir-sessao-voto")
    @ApiOperation(value = "Abrir uma sessao de votação")
    public PautaDTO abrirSessaoVoto(@RequestBody PautaSessaoDTO dto) {
        Pauta pauta = pautaService.abrirSessaoVotacao(dto.getId(), dto.getDuracaoVotacaoMinutos());
        return pautaMapper.convertToDTO(pauta);
    }

}
