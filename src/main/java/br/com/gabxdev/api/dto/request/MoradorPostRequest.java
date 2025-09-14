package br.com.gabxdev.api.dto.request;

public record MoradorPostRequest(
        String nome,

        String cpf,

        String endereco,

        String celular
) {
}
