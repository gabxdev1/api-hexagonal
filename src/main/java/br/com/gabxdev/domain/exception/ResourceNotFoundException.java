package br.com.gabxdev.domain.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceName, String identification) {
        super(resourceName + " not found by: " + identification);
    }
}
