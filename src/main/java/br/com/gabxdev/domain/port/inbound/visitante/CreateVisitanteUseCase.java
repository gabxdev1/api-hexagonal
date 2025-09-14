package br.com.gabxdev.domain.port.inbound.visitante;

import br.com.gabxdev.domain.model.Visitante;

public interface CreateVisitanteUseCase {
    Visitante execute(Visitante visitante);


}
