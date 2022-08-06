/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.repository.exception;

public class NewRepositoryDirectoryException extends RuntimeException {

    public NewRepositoryDirectoryException(String projectName) {
        super("Unable to create new project: " + projectName);
    }
}
