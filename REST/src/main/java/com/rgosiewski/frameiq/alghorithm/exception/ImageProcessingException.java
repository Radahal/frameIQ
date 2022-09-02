/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.alghorithm.exception;

import java.nio.file.Path;

public class ImageProcessingException extends RuntimeException {
    public ImageProcessingException(Path imagePath) {
        super(String.format("Unable to process image: %s", imagePath.toString()));
    }
}
