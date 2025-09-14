package br.com.gabxdev.application.visitante;

import br.com.gabxdev.domain.model.Visitante;
import br.com.gabxdev.domain.port.inbound.visitante.CreateVisitanteUseCase;
import br.com.gabxdev.domain.port.outbound.VisitanteRepositoryPort;
import br.com.gabxdev.domain.service.ValidatorVisitanteService;

public class CreateVisitanteService implements CreateVisitanteUseCase {

    private final VisitanteRepositoryPort repository;

    private final ValidatorVisitanteService validator;

    public CreateVisitanteService(VisitanteRepositoryPort repository, ValidatorVisitanteService validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public Visitante execute(Visitante visitante) {
        var existsByRg = repository.existsByRg(visitante.getRg());

        validator.validateSingleRg(visitante.getRg(), existsByRg);

        return repository.create(visitante);
    }
}
