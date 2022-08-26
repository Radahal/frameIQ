/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.workspace.exception;

public class NewWorkspaceDirectoryException extends RuntimeException {

    public NewWorkspaceDirectoryException(String projectName) {
        super("Unable to create new project: " + projectName);
    }
}
