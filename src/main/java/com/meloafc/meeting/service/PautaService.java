package com.meloafc.meeting.service;

import com.meloafc.meeting.model.Pauta;
import com.meloafc.meeting.service.base.AbstractService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PautaService extends AbstractService<Pauta, Long> {

    public PautaService(JpaRepository<Pauta, Long> repository) {
        super(repository);
    }

}
