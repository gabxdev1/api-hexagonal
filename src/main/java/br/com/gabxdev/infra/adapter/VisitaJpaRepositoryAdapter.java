package br.com.gabxdev.infra.adapter;

import br.com.gabxdev.domain.model.Visita;
import br.com.gabxdev.domain.port.outbound.VisitaRepositoryPort;
import br.com.gabxdev.infra.mapper.VisitaOutboundMapper;
import br.com.gabxdev.infra.repository.VisitaJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class VisitaJpaRepositoryAdapter implements VisitaRepositoryPort {

    private final VisitaJpaRepository repository;

    private final VisitaOutboundMapper mapper;

    @Override
    public Visita create(Visita visita) {
        var visitaToCreate = mapper.toEntity(visita);

        var savedVisita = repository.save(visitaToCreate);

        return mapper.toDomain(savedVisita);
    }

    @Override
    public List<Visita> findVisitaByMorador(Long moradorId) {
        var visitasByMorador = repository.findVisitaByMorador_Id(moradorId);

        return mapper.toDomainList(visitasByMorador);
    }

    @Override
    public List<Visita> findVisitaByVisitante(Long visitanteId) {
        var visitasByVisitante = repository.findVisitaByVisitante_Id(visitanteId);

        return mapper.toDomainList(visitasByVisitante);
    }

    @Override
    public List<Visita> findVisitaByVisitanteAndMorador(Long visitanteId, Long moradorId) {
        var visitasByVisitanteIdAndMoradorId = repository.findVisitaByVisitante_IdAndMorador_Id(visitanteId, moradorId);

        return mapper.toDomainList(visitasByVisitanteIdAndMoradorId);
    }


}
