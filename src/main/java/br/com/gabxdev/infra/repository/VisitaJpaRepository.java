package br.com.gabxdev.infra.repository;

import br.com.gabxdev.infra.entity.VisitaEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitaJpaRepository extends JpaRepository<VisitaEntity, Long> {
    @EntityGraph(attributePaths = {"visitante", "visitante.pessoa", "morador", "morador.pessoa"})
    List<VisitaEntity> findVisitaByMorador_Id(Long moradorId);

    @EntityGraph(attributePaths = {"visitante", "visitante.pessoa", "morador", "morador.pessoa"})
    List<VisitaEntity> findVisitaByVisitante_Id(Long visitanteId);

    @EntityGraph(attributePaths = {"visitante", "visitante.pessoa", "morador", "morador.pessoa"})
    List<VisitaEntity> findVisitaByVisitante_IdAndMorador_Id(Long visitanteId, Long moradorId);
}
