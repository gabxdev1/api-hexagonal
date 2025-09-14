package br.com.gabxdev.application.morador;

import br.com.gabxdev.domain.exception.ResourceNotFoundException;
import br.com.gabxdev.domain.model.Morador;
import br.com.gabxdev.domain.port.inbound.morador.FindMoradorByIdUseCase;
import br.com.gabxdev.domain.port.outbound.MoradorRepositoryPort;

public class FindMoradorByIdService implements FindMoradorByIdUseCase {

    private final MoradorRepositoryPort repository;

    public FindMoradorByIdService(MoradorRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Morador execute(Long moradorId) {
        return repository.findById(moradorId)
                .orElseThrow(() -> new ResourceNotFoundException("morador", moradorId.toString()));
    }
}
