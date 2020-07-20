package com.meloafc.meeting.service;

import com.meloafc.meeting.enums.PautaStatus;
import com.meloafc.meeting.exception.InvalidValueException;
import com.meloafc.meeting.model.Pauta;
import com.meloafc.meeting.service.base.AbstractService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PautaService extends AbstractService<Pauta, Long> {

    public PautaService(JpaRepository<Pauta, Long> repository) {
        super(repository);
    }

    public Pauta abrirSessaoVotacao(Long id, Long duracaoVotacaoMinutos) {
        Pauta pauta = findOne(id);

        if(duracaoVotacaoMinutos == null || duracaoVotacaoMinutos < 1L) {
            duracaoVotacaoMinutos = 1L;
        }

        if(pauta.getStatus().equals(PautaStatus.NOVA)) {
            pauta.setInicioVotacao(LocalDateTime.now());
            pauta.setDuracaoVotacaoMinutos(duracaoVotacaoMinutos);
        } else {
            throw new InvalidValueException("ruling.cannot.start.voting.session");
        }

        return update(pauta);
    }

}
