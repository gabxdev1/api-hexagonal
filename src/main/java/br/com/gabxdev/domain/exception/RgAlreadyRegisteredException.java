package br.com.gabxdev.domain.exception;

public class RgAlreadyRegisteredException extends RuntimeException {
    public RgAlreadyRegisteredException(String rg) {
        super("RG already registered: " + rg);
    }
}
