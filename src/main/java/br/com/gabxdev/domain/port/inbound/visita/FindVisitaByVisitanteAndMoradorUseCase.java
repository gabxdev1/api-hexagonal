package br.com.gabxdev.domain.port.inbound.visita;

import br.com.gabxdev.domain.model.Visita;

import java.util.List;

public interface FindVisitaByVisitanteAndMoradorUseCase {
    List<Visita> execute(Long visitanteId, Long moradorId);
}
