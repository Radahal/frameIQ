/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.workspace.exception;

import com.rgosiewski.frameiq.workspace.enums.FileExtensions;

public class NewWorkspaceFileException extends RuntimeException {

    public NewWorkspaceFileException(String fileName, FileExtensions extension, String projectName) {
        super("Unable to create new " + extension+ " file: " + fileName + " in the project: " + projectName);
    }
}
