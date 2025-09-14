package br.com.gabxdev.domain.port.inbound.usuario;

import br.com.gabxdev.domain.model.Usuario;

public interface CreateUsuarioUseCase {
    Usuario execute(Usuario usuario);
}
