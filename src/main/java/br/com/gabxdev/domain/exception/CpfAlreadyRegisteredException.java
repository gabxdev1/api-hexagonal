package br.com.gabxdev.domain.exception;

public class CpfAlreadyRegisteredException extends RuntimeException {
    public CpfAlreadyRegisteredException(String cpf) {
        super("CPF already registered: " + cpf);
    }
}
