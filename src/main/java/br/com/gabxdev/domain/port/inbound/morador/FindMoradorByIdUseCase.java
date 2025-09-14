package br.com.gabxdev.domain.port.inbound.morador;

import br.com.gabxdev.domain.model.Morador;

public interface FindMoradorByIdUseCase {
    Morador execute(Long moradorId);
}
