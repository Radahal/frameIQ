package com.rgosiewski.frameiq.server.common.exception;

import java.util.List;

public abstract class MultiDetailException extends RuntimeException {

    public MultiDetailException(String message) {
        super(message);
    }

    public abstract List<ExceptionResponse.Fault.Detail> getDetails();
}
