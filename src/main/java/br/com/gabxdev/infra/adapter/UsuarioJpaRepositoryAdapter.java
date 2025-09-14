package br.com.gabxdev.infra.adapter;

import br.com.gabxdev.domain.model.Usuario;
import br.com.gabxdev.domain.port.outbound.UsuarioRepositoryPort;
import br.com.gabxdev.infra.mapper.UsuarioOutboundMapper;
import br.com.gabxdev.infra.repository.UsuarioJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UsuarioJpaRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioJpaRepository repository;

    private final UsuarioOutboundMapper mapper;

    @Override
    public Usuario create(Usuario usuario) {
        var usuarioEntity = mapper.toEntity(usuario);

        var savedUsuarioEntity = repository.save(usuarioEntity);

        return mapper.toDomain(savedUsuarioEntity);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        var usuarioEntity = repository.findByEmailIgnoreCase(email);

        return Optional.ofNullable(usuarioEntity)
                .map(mapper::toDomain);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return repository.existsByEmailIgnoreCase(email);
    }
}
