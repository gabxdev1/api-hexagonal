package br.com.gabxdev.infra.repository;

import br.com.gabxdev.infra.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {
    @EntityGraph(attributePaths = {"pessoa"})
    UsuarioEntity findByEmailIgnoreCase(String email);

    Boolean existsByEmailIgnoreCase(String email);
}
