package br.com.gabxdev.domain.service;

import br.com.gabxdev.domain.exception.EmailAlreadyRegisteredException;

public class ValidatorUsuarioService {
    public void validateSingleEmail(String email, Boolean existsByEmail) {
        if (existsByEmail) {
            throw new EmailAlreadyRegisteredException(email);
        }
    }
}
