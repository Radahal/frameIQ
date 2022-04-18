package com.rgosiewski.frameiq.common.exception;

public class IllegalEnumValueException extends RuntimeException {
    private final static String MESSAGE = "Enum not found for value";

    public IllegalEnumValueException() {
        super(MESSAGE);
    }

    public IllegalEnumValueException(String message) {
        super(String.format("%s : %s", MESSAGE, message));
    }

    public IllegalEnumValueException(String message, Throwable cause) {
        super(String.format("%s : %s", MESSAGE, message), cause);
    }

    public IllegalEnumValueException(Throwable cause) {
        super(cause);
    }
}
