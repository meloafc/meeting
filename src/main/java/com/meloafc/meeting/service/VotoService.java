package com.meloafc.meeting.service;

import com.meloafc.meeting.enums.PautaStatus;
import com.meloafc.meeting.exception.InvalidValueException;
import com.meloafc.meeting.model.Pauta;
import com.meloafc.meeting.model.Usuario;
import com.meloafc.meeting.model.Voto;
import com.meloafc.meeting.repository.VotoRepository;
import com.meloafc.meeting.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VotoService extends AbstractService<Voto, Long, VotoRepository> {

    @Autowired
    PautaService pautaService;

    @Autowired
    UsuarioService usuarioService;

    public VotoService(VotoRepository repository) {
        super(repository);
    }

    public Voto votar(Long pautaId, Long usuarioId, Boolean aprovaPauta) {
        Pauta pauta = pautaService.findOne(pautaId);

        if(pauta.getStatus() != PautaStatus.EM_VOTACAO) {
            throw new InvalidValueException("ruling.is.not.open.for.voting");
        }

        Usuario usuario = usuarioService.findOne(usuarioId);

        List<Voto> votos = getRepository().findAllByPautaIdAndUsuarioId(pautaId, usuarioId);
        if(!votos.isEmpty()) {
            throw new InvalidValueException("user.has.already.voted.on.this.ruling");
        }

        Voto voto = Voto.builder()
                .dataHoraVotacao(LocalDateTime.now())
                .pauta(pauta)
                .usuario(usuario)
                .aprovaPauta(aprovaPauta)
                .build();
        return add(voto);
    }

    public long countByPauta(Long pautaId, Boolean aprovaPauta) {
        return getRepository().countByPautaIdAndAprovaPauta(pautaId, aprovaPauta);
    }

}
