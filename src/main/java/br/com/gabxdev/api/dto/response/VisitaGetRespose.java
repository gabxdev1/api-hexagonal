package br.com.gabxdev.api.dto.response;

import java.time.LocalDateTime;

public record VisitaGetRespose(
        Long id,

        LocalDateTime dataVisita,

        VisitanteGetResponse visitante,

        MoradorGetResponse morador
) {
}
