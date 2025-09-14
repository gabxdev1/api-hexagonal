package br.com.gabxdev.domain.port.inbound.visita;

import br.com.gabxdev.domain.model.Visita;

import java.util.List;

public interface FindVisitaByMoradorUseCase {
    List<Visita> execute(Long moradorId);
}
