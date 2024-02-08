package com.enviro.assessment.grad001.siyathandazamqhamane.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message, Long investorId) {
        super(message);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
    public ResourceNotFoundException(String message, String productType) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
