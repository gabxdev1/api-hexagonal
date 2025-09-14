package br.com.gabxdev.api.dto.response;

public record ErrorResponse(
        int code,

        String path,

        String message
) {
}
