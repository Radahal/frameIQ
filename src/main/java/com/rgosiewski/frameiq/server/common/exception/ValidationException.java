package com.rgosiewski.frameiq.server.common.exception;

public class ValidationException extends RuntimeException {

    public ValidationException(String validationError) {
        super(String.format("Validation error: %s", validationError));
    }
}
