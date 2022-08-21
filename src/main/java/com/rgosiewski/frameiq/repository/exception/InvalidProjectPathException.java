/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.repository.exception;

public class InvalidProjectPathException extends RuntimeException {

    public InvalidProjectPathException(String projectName) {
        super("Invalid project path for: " + projectName);
    }
}
