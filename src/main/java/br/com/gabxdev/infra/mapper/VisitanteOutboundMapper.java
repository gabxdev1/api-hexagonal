package br.com.gabxdev.infra.mapper;

import br.com.gabxdev.domain.model.Visitante;
import br.com.gabxdev.infra.entity.VisitanteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VisitanteOutboundMapper {
    VisitanteEntity toEntity(Visitante domain);

    Visitante toDomain(VisitanteEntity entity);
}
