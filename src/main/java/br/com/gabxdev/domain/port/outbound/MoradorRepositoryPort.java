package br.com.gabxdev.domain.port.outbound;

import br.com.gabxdev.domain.model.Morador;

import java.util.Optional;

public interface MoradorRepositoryPort {
    Morador create(Morador morador);

    Optional<Morador> findByCpf(String email);

    Boolean existsByCpf(String cpf);

    Optional<Morador> findById(Long id);
}
