package br.com.gabxdev.api.dto.response;

public record MoradorPostResponse(
        Long id,

        String nome,

        String cpf,

        String endereco,

        String celular
) {
}
