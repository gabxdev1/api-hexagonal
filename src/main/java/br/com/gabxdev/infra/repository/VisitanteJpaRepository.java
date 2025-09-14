package br.com.gabxdev.infra.repository;

import br.com.gabxdev.infra.entity.VisitanteEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitanteJpaRepository extends JpaRepository<VisitanteEntity, Long> {

    @EntityGraph(attributePaths = {"pessoa"})
    VisitanteEntity findByRgIgnoreCase(String rg);

    Boolean existsByRgIgnoreCase(String rg);

    VisitanteEntity findVisitanteEntityById(Long id);
}
