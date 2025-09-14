package br.com.gabxdev.application.usuario;

import br.com.gabxdev.domain.exception.ResourceNotFoundException;
import br.com.gabxdev.domain.model.Usuario;
import br.com.gabxdev.domain.port.inbound.usuario.FindUsuarioByEmailUseCase;
import br.com.gabxdev.domain.port.outbound.UsuarioRepositoryPort;

public class FindUsuarioByEmailService implements FindUsuarioByEmailUseCase {

    private final UsuarioRepositoryPort repository;

    public FindUsuarioByEmailService(UsuarioRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Usuario execute(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("usuario", email));
    }
}
