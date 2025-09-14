package br.com.gabxdev.api.dto.request;

public record VisitaPostRequest(
        Long moradorId,

        Long visitanteId
) {
}
