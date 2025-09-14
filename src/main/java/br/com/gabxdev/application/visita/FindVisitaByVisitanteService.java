package br.com.gabxdev.application.visita;

import br.com.gabxdev.domain.model.Visita;
import br.com.gabxdev.domain.port.inbound.visita.FindVisitaByVisitanteUseCase;
import br.com.gabxdev.domain.port.outbound.VisitaRepositoryPort;

import java.util.List;

public class FindVisitaByVisitanteService implements FindVisitaByVisitanteUseCase {

    private final VisitaRepositoryPort repository;

    public FindVisitaByVisitanteService(VisitaRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public List<Visita> execute(Long visitanteId) {
        return repository.findVisitaByVisitante(visitanteId);
    }
}
