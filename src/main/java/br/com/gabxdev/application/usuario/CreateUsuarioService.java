package br.com.gabxdev.application.usuario;

import br.com.gabxdev.domain.model.Usuario;
import br.com.gabxdev.domain.port.inbound.usuario.CreateUsuarioUseCase;
import br.com.gabxdev.domain.port.outbound.UsuarioRepositoryPort;
import br.com.gabxdev.domain.service.ValidatorUsuarioService;

public class CreateUsuarioService implements CreateUsuarioUseCase {

    private final UsuarioRepositoryPort repository;

    private final ValidatorUsuarioService validator;

    public CreateUsuarioService(UsuarioRepositoryPort repository, ValidatorUsuarioService validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public Usuario execute(Usuario usuario) {
        var existsByEmail = repository.existsByEmail(usuario.getEmail());

        validator.validateSingleEmail(usuario.getEmail(), existsByEmail);

        return repository.create(usuario);
    }
}
