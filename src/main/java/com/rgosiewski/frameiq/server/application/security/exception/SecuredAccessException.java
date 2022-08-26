/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.application.security.exception;

public class SecuredAccessException extends RuntimeException {

    public SecuredAccessException(String message) {
        super(message);
    }
}
