package br.com.gabxdev.domain.port.inbound.visita;

import br.com.gabxdev.domain.model.Visita;

import java.util.List;

public interface FindVisitaByVisitanteUseCase {
    List<Visita> execute(Long visitanteId);
}
