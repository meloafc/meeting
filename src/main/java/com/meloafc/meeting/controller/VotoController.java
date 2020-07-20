package com.meloafc.meeting.controller;

import com.meloafc.meeting.dto.VotoDTO;
import com.meloafc.meeting.service.VotoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/votos")
public class VotoController {

    @Autowired
    VotoService votoService;

    @PostMapping()
    @ApiOperation(value = "Votar")
    public void votar(@RequestBody VotoDTO dto) {
        votoService.votar(dto.getPautaId(), dto.getUsuarioId(), dto.getAprovaPauta());
    }

}
