/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.alghorithm.exception;

import java.nio.file.Path;

public class ReadVideoException extends RuntimeException {
    public ReadVideoException(Path videoPath) {
        super(String.format("Unable to read video: %s", videoPath.toString()));
    }
}
