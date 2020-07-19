package com.meloafc.meeting.service;

import com.meloafc.meeting.model.Voto;
import com.meloafc.meeting.service.base.AbstractService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class VotoService extends AbstractService<Voto, Long> {

    public VotoService(JpaRepository<Voto, Long> repository) {
        super(repository);
    }

}
