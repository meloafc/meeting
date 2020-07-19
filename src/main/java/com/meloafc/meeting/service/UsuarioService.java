package com.meloafc.meeting.service;

import com.meloafc.meeting.model.Usuario;
import com.meloafc.meeting.service.base.AbstractService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends AbstractService<Usuario, Long> {

    public UsuarioService(JpaRepository<Usuario, Long> repository) {
        super(repository);
    }

}
