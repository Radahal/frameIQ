/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.repository.exception;

import com.rgosiewski.frameiq.repository.enums.FileExtensions;

public class NewRepositoryFileException extends RuntimeException {

    public NewRepositoryFileException(String fileName, FileExtensions extension, String projectName) {
        super("Unable to create new " + extension+ " file: " + fileName + " in the project: " + projectName);
    }
}
