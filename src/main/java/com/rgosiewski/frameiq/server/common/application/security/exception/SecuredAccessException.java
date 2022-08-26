/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.common.application.security.exception;

public class SecuredAccessException extends RuntimeException {

    public SecuredAccessException(String message) {
        super(message);
    }
}
