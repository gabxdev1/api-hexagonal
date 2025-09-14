package br.com.gabxdev.api.mapper;

import br.com.gabxdev.api.dto.request.VisitantePostRequest;
import br.com.gabxdev.api.dto.response.VisitanteGetResponse;
import br.com.gabxdev.api.dto.response.VisitantePostResponse;
import br.com.gabxdev.domain.model.Visitante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VisitanteInboundMapper {
    @Mapping(target = "pessoa.nome", source = "request.nome")
    Visitante toVisitante(VisitantePostRequest request);

    @Mapping(target = "nome", source = "visitante.pessoa.nome")
    VisitantePostResponse toVisitantePostResponse(Visitante visitante);

    @Mapping(target = "nome", source = "visitante.pessoa.nome")
    VisitanteGetResponse toVisitanteGetResponse(Visitante visitante);
}
