package br.com.gabxdev.application.visitante;

import br.com.gabxdev.domain.exception.ResourceNotFoundException;
import br.com.gabxdev.domain.model.Visitante;
import br.com.gabxdev.domain.port.inbound.visitante.FindVisitanteByIdUseCase;
import br.com.gabxdev.domain.port.outbound.VisitanteRepositoryPort;

public class FindVisitanteByIdService implements FindVisitanteByIdUseCase {

    private final VisitanteRepositoryPort repository;

    public FindVisitanteByIdService(VisitanteRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Visitante execute(Long visitanteId) {
        return repository.findById(visitanteId)
                .orElseThrow(() -> new ResourceNotFoundException("visitante", visitanteId.toString()));
    }
}
