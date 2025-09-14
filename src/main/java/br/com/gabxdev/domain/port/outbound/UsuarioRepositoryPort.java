package br.com.gabxdev.domain.port.outbound;

import br.com.gabxdev.domain.model.Usuario;

import java.util.Optional;

public interface UsuarioRepositoryPort {
    Usuario create(Usuario usuario);

    Optional<Usuario> findByEmail(String email);

    Boolean existsByEmail(String email);
}
