package br.com.gabxdev.api.dto.request;

public record UsuarioPostRequest(
        String nome,
        String email,
        String senha,
        Boolean administrador
) {
}
