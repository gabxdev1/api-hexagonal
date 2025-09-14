package br.com.gabxdev.domain.port.inbound.morador;

import br.com.gabxdev.domain.model.Morador;

public interface FindMoradorByCpfUseCase {
    Morador execute(String cpf);
}
