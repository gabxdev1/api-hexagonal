package br.com.gabxdev.application.morador;

import br.com.gabxdev.domain.exception.ResourceNotFoundException;
import br.com.gabxdev.domain.model.Morador;
import br.com.gabxdev.domain.port.inbound.morador.FindMoradorByCpfUseCase;
import br.com.gabxdev.domain.port.outbound.MoradorRepositoryPort;

public class FindMoradorByCpfService implements FindMoradorByCpfUseCase {

    private final MoradorRepositoryPort repository;

    public FindMoradorByCpfService(MoradorRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Morador execute(String cpf) {
        return repository.findByCpf(cpf).orElseThrow(() -> new ResourceNotFoundException("morador", cpf));
    }
}
