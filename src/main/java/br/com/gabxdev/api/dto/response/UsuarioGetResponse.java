package br.com.gabxdev.api.dto.response;

public record UsuarioGetResponse(
        Long id,
        String email,
        Boolean administrador,
        String nome
) {
}
