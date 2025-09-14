package br.com.gabxdev.api;

import br.com.gabxdev.api.dto.response.ErrorResponse;
import br.com.gabxdev.domain.exception.CpfAlreadyRegisteredException;
import br.com.gabxdev.domain.exception.EmailAlreadyRegisteredException;
import br.com.gabxdev.domain.exception.ResourceNotFoundException;
import br.com.gabxdev.domain.exception.RgAlreadyRegisteredException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
        var path = request.getRequestURI();

        var errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), path, ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler({
            CpfAlreadyRegisteredException.class,
            EmailAlreadyRegisteredException.class,
            RgAlreadyRegisteredException.class
    })
    public ResponseEntity<ErrorResponse> handleConflictException(RuntimeException ex, HttpServletRequest request) {
        var path = request.getRequestURI();

        var errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), path, ex.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex, HttpServletRequest request) {
        var path = request.getRequestURI();

        var errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), path, ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
