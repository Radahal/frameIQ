package com.rgosiewski.frameiq.common.validation;

import com.rgosiewski.frameiq.common.exception.ValidationException;

public abstract class DataValidator<T> {

    public abstract void validate(T data) throws ValidationException;
}
