package br.com.gabxdev.domain.service;

import br.com.gabxdev.domain.exception.RgAlreadyRegisteredException;

public class ValidatorVisitanteService {
    public void validateSingleRg(String rg, Boolean existsByRg) {
        if (existsByRg) {
            throw new RgAlreadyRegisteredException(rg);
        }
    }
}
