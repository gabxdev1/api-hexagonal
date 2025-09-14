package br.com.gabxdev.application.visita;

import br.com.gabxdev.domain.model.Visita;
import br.com.gabxdev.domain.port.inbound.visita.FindVisitaByMoradorUseCase;
import br.com.gabxdev.domain.port.outbound.VisitaRepositoryPort;

import java.util.List;

public class FindVisitaByMoradorService implements FindVisitaByMoradorUseCase {

    private final VisitaRepositoryPort repository;

    public FindVisitaByMoradorService(VisitaRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public List<Visita> execute(Long moradorId) {
        return repository.findVisitaByMorador(moradorId);
    }
}
