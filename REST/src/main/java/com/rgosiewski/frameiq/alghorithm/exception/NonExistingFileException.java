/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.alghorithm.exception;

import java.nio.file.Path;

public class NonExistingFileException extends RuntimeException {
    public NonExistingFileException(Path imagePath) {
        super(String.format("Non existing image path %s", imagePath));
    }
}
