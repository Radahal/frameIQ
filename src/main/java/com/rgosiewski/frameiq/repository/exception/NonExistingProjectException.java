/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.repository.exception;

public class NonExistingProjectException extends RuntimeException {

    public NonExistingProjectException(String projectName) {
        super("Project does not exist: " + projectName);
    }
}
