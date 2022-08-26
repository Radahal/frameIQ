/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.workspace.exception;

public class InvalidFileExtensionException extends RuntimeException {

    public InvalidFileExtensionException(String fileName) {
        super("Invalid extension in file: " + fileName);
    }
}
