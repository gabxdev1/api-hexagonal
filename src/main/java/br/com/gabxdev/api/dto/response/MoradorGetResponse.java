package br.com.gabxdev.api.dto.response;

public record MoradorGetResponse(
        Long id,

        String nome,

        String cpf,

        String endereco,

        String celular
) {
}
