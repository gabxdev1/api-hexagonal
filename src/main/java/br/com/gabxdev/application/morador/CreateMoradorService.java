package br.com.gabxdev.application.morador;

import br.com.gabxdev.domain.model.Morador;
import br.com.gabxdev.domain.port.inbound.morador.CreateMoradorUseCase;
import br.com.gabxdev.domain.port.outbound.MoradorRepositoryPort;
import br.com.gabxdev.domain.service.ValidatorMoradorService;

public class CreateMoradorService implements CreateMoradorUseCase {

    private final ValidatorMoradorService validator;

    private final MoradorRepositoryPort repository;

    public CreateMoradorService(ValidatorMoradorService validator, MoradorRepositoryPort repository) {
        this.validator = validator;
        this.repository = repository;
    }

    @Override
    public Morador execute(Morador morador) {
        var existsByCpf = repository.existsByCpf(morador.getCpf());

        validator.validateSingleCpf(morador.getCpf(), existsByCpf);

        return repository.create(morador);
    }
}
