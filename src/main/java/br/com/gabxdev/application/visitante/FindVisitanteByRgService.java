package br.com.gabxdev.application.visitante;

import br.com.gabxdev.domain.exception.ResourceNotFoundException;
import br.com.gabxdev.domain.model.Visitante;
import br.com.gabxdev.domain.port.inbound.visitante.FindVisitanteByRgUseCase;
import br.com.gabxdev.domain.port.outbound.VisitanteRepositoryPort;

public class FindVisitanteByRgService implements FindVisitanteByRgUseCase {

    private final VisitanteRepositoryPort repository;

    public FindVisitanteByRgService(VisitanteRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Visitante execute(String rg) {
        return repository.findByRg(rg).orElseThrow(() -> new ResourceNotFoundException("visitante", rg));
    }
}
