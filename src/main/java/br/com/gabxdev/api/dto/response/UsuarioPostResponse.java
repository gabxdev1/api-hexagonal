package br.com.gabxdev.api.dto.response;

public record UsuarioPostResponse(
        Long id,
        String email,
        Boolean administrador,
        String nome
) {
}
