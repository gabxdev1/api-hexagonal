package br.com.gabxdev.api.mapper;

import br.com.gabxdev.api.dto.request.UsuarioPostRequest;
import br.com.gabxdev.api.dto.response.UsuarioGetResponse;
import br.com.gabxdev.api.dto.response.UsuarioPostResponse;
import br.com.gabxdev.domain.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuarioInboundMapper {
    @Mapping(target = "pessoa.nome", source = "request.nome")
    Usuario toUsuario(UsuarioPostRequest request);

    @Mapping(target = "nome", source = "usuario.pessoa.nome")
    UsuarioPostResponse toUsuarioPostResponse(Usuario usuario);

    @Mapping(target = "nome", source = "usuario.pessoa.nome")
    UsuarioGetResponse toUsuarioGetResponse(Usuario usuario);
}
