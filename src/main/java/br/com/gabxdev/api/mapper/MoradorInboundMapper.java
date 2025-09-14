package br.com.gabxdev.api.mapper;

import br.com.gabxdev.api.dto.request.MoradorPostRequest;
import br.com.gabxdev.api.dto.response.MoradorGetResponse;
import br.com.gabxdev.api.dto.response.MoradorPostResponse;
import br.com.gabxdev.domain.model.Morador;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MoradorInboundMapper {
    @Mapping(target = "pessoa.nome", source = "request.nome")
    Morador toMorador(MoradorPostRequest request);

    @Mapping(target = "nome", source = "morador.pessoa.nome")
    MoradorPostResponse toMoradorPostResponse(Morador morador);

    @Mapping(target = "nome", source = "morador.pessoa.nome")
    MoradorGetResponse toMoradorGetResponse(Morador morador);
}
