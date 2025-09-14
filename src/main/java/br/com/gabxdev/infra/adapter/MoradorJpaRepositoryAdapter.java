package br.com.gabxdev.infra.adapter;

import br.com.gabxdev.domain.model.Morador;
import br.com.gabxdev.domain.port.outbound.MoradorRepositoryPort;
import br.com.gabxdev.infra.mapper.MoradorOutboundMapper;
import br.com.gabxdev.infra.repository.MoradorJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MoradorJpaRepositoryAdapter implements MoradorRepositoryPort {

    private final MoradorJpaRepository repository;

    private final MoradorOutboundMapper mapper;

    @Override
    public Morador create(Morador morador) {
        var moradorEntity = mapper.toEntity(morador);

        var savedMoradorEntity = repository.save(moradorEntity);

        return mapper.toDomain(savedMoradorEntity);
    }

    @Override
    public Optional<Morador> findByCpf(String cpf) {
        var foundMoradorEntity = repository.findByCpfIgnoreCase(cpf);

        return Optional.ofNullable(foundMoradorEntity)
                .map(mapper::toDomain);
    }

    @Override
    public Boolean existsByCpf(String email) {
        return repository.existsByCpfIgnoreCase(email);
    }

    @Override
    public Optional<Morador> findById(Long id) {
        var foundMoradorEntity = repository.findMoradorEntityById(id);

        return Optional.ofNullable(foundMoradorEntity)
                .map(mapper::toDomain);
    }
}
