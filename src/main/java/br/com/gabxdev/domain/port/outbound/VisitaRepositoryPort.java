package br.com.gabxdev.domain.port.outbound;

import br.com.gabxdev.domain.model.Visita;

import java.util.List;

public interface VisitaRepositoryPort {
    Visita create(Visita visita);

    List<Visita> findVisitaByMorador(Long moradorId);

    List<Visita> findVisitaByVisitante(Long visitanteId);

    List<Visita> findVisitaByVisitanteAndMorador(Long visitanteId, Long moradorId);
}
