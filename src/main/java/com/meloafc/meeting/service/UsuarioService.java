package com.meloafc.meeting.service;

import com.meloafc.meeting.model.Usuario;
import com.meloafc.meeting.repository.UsuarioRepository;
import com.meloafc.meeting.service.base.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends AbstractService<Usuario, Long, UsuarioRepository> {

    public UsuarioService(UsuarioRepository repository) {
        super(repository);
    }

    @Override
    protected String getNotFoundMessage() {
        return "user.notFound";
    }
}
