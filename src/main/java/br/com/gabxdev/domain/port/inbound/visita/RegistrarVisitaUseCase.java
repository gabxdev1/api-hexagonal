package br.com.gabxdev.domain.port.inbound.visita;

import br.com.gabxdev.domain.model.Visita;

public interface RegistrarVisitaUseCase {
    Visita execute(Long visitanteId, Long moradorId);
}
