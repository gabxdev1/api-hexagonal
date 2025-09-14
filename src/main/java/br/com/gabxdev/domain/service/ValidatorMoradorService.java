package br.com.gabxdev.domain.service;

import br.com.gabxdev.domain.exception.CpfAlreadyRegisteredException;

public class ValidatorMoradorService {
    public void validateSingleCpf(String cpf, Boolean existsByCpf) {
        if (existsByCpf) {
            throw new CpfAlreadyRegisteredException(cpf);
        }
    }
}
