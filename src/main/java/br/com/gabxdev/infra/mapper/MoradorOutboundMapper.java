package br.com.gabxdev.infra.mapper;

import br.com.gabxdev.domain.model.Morador;
import br.com.gabxdev.infra.entity.MoradorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MoradorOutboundMapper {
    MoradorEntity toEntity(Morador domain);

    Morador toDomain(MoradorEntity entity);
}
