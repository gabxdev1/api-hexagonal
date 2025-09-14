package br.com.gabxdev.application.visita;

import br.com.gabxdev.domain.model.Visita;
import br.com.gabxdev.domain.port.inbound.visita.FindVisitaByVisitanteAndMoradorUseCase;
import br.com.gabxdev.domain.port.outbound.VisitaRepositoryPort;

import java.util.List;

public class FindVisitaByVisitanteAndMoradorService implements FindVisitaByVisitanteAndMoradorUseCase {

    private final VisitaRepositoryPort repository;

    public FindVisitaByVisitanteAndMoradorService(VisitaRepositoryPort repository) {
        this.repository = repository;
    }


    @Override
    public List<Visita> execute(Long visitanteId, Long moradorId) {
        return repository.findVisitaByVisitanteAndMorador(visitanteId, moradorId);
    }
}
