package com.rgosiewski.frameiq.server.common.stereotype;

import com.rgosiewski.frameiq.server.common.enums.RightType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface SecuredAccess {
    RightType minimumRightRequired() default RightType.VIEW;
}
