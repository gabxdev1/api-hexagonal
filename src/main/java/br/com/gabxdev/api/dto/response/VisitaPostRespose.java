package br.com.gabxdev.api.dto.response;

import java.time.LocalDateTime;

public record VisitaPostRespose(
        Long id,

        LocalDateTime dataVisita,

        VisitantePostResponse visitante,

        MoradorPostResponse morador
) {
}
