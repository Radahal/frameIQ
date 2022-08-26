/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.alghorithm.exception;

import java.nio.file.Path;

public class ImageExifReaderException extends RuntimeException {
    public ImageExifReaderException(Path imagePath) {
        super(String.format("Unable to extract exif properties from image: %s", imagePath.toString()));
    }
}
