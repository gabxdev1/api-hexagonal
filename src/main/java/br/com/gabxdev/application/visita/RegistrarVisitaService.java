package br.com.gabxdev.application.visita;

import br.com.gabxdev.domain.model.Visita;
import br.com.gabxdev.domain.port.inbound.morador.FindMoradorByIdUseCase;
import br.com.gabxdev.domain.port.inbound.visita.RegistrarVisitaUseCase;
import br.com.gabxdev.domain.port.inbound.visitante.FindVisitanteByIdUseCase;
import br.com.gabxdev.domain.port.outbound.VisitaRepositoryPort;

import java.time.LocalDateTime;

public class RegistrarVisitaService implements RegistrarVisitaUseCase {

    private final VisitaRepositoryPort repository;

    private final FindMoradorByIdUseCase findMoradorById;

    private final FindVisitanteByIdUseCase findVisitanteById;

    public RegistrarVisitaService(VisitaRepositoryPort repository, FindMoradorByIdUseCase findMoradorById, FindVisitanteByIdUseCase findVisitanteById) {
        this.repository = repository;
        this.findMoradorById = findMoradorById;
        this.findVisitanteById = findVisitanteById;
    }

    @Override
    public Visita execute(Long visitanteId, Long moradorId) {
        var visitante = findVisitanteById.execute(visitanteId);
        var morador = findMoradorById.execute(moradorId);

        var visitaToSave = new Visita(null, LocalDateTime.now(), visitante, morador);

        return repository.create(visitaToSave);
    }
}
