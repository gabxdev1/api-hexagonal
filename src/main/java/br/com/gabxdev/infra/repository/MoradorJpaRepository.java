package br.com.gabxdev.infra.repository;

import br.com.gabxdev.infra.entity.MoradorEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoradorJpaRepository extends JpaRepository<MoradorEntity, Long> {
    @EntityGraph(attributePaths = {"pessoa"})
    MoradorEntity findByCpfIgnoreCase(String cpf);

    Boolean existsByCpfIgnoreCase(String cpf);

    MoradorEntity findMoradorEntityById(Long id);
}
