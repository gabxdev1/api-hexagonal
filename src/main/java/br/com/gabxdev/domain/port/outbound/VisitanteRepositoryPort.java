package br.com.gabxdev.domain.port.outbound;

import br.com.gabxdev.domain.model.Visitante;

import java.util.Optional;

public interface VisitanteRepositoryPort {
    Visitante create(Visitante visitante);

    Optional<Visitante> findByRg(String rg);

    Boolean existsByRg(String rg);

    Optional<Visitante> findById(Long id);
}
