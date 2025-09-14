package br.com.gabxdev.infra.mapper;

import br.com.gabxdev.domain.model.Visita;
import br.com.gabxdev.infra.entity.VisitaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VisitaOutboundMapper {
    VisitaEntity toEntity(Visita domain);

    Visita toDomain(VisitaEntity entity);

    List<Visita> toDomainList(List<VisitaEntity> entityList);
}
