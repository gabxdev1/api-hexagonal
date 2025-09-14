package br.com.gabxdev.infra.mapper;

import br.com.gabxdev.domain.model.Usuario;
import br.com.gabxdev.infra.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuarioOutboundMapper {
    UsuarioEntity toEntity(Usuario domain);

    Usuario toDomain(UsuarioEntity entity);
}
