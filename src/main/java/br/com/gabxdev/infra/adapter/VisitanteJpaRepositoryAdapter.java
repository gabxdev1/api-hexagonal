package br.com.gabxdev.infra.adapter;

import br.com.gabxdev.domain.model.Visitante;
import br.com.gabxdev.domain.port.outbound.VisitanteRepositoryPort;
import br.com.gabxdev.infra.mapper.VisitanteOutboundMapper;
import br.com.gabxdev.infra.repository.VisitanteJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class VisitanteJpaRepositoryAdapter implements VisitanteRepositoryPort {

    private final VisitanteJpaRepository repository;

    private final VisitanteOutboundMapper mapper;

    @Override
    public Visitante create(Visitante visitante) {
        var visitanteEntity = mapper.toEntity(visitante);

        var savedVisitante = repository.save(visitanteEntity);

        return mapper.toDomain(savedVisitante);
    }

    @Override
    public Optional<Visitante> findByRg(String rg) {
        var visitanteEntity = repository.findByRgIgnoreCase(rg);

        return Optional.ofNullable(visitanteEntity)
                .map(mapper::toDomain);
    }

    @Override
    public Boolean existsByRg(String rg) {
        return repository.existsByRgIgnoreCase(rg);
    }

    @Override
    public Optional<Visitante> findById(Long id) {
        var visitanteEntity = repository.findVisitanteEntityById(id);

        return Optional.ofNullable(visitanteEntity)
                .map(mapper::toDomain);
    }
}
