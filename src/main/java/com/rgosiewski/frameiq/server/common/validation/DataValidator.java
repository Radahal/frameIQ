package com.rgosiewski.frameiq.server.common.validation;

import com.rgosiewski.frameiq.server.common.exception.ValidationException;

public abstract class DataValidator<T> {

    public abstract void validate(T data) throws ValidationException;
}
