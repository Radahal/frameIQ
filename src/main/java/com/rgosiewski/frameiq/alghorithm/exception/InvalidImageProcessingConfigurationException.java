/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.alghorithm.exception;

import com.rgosiewski.frameiq.alghorithm.configuration.ImageProcessingConfiguration;

public class InvalidImageProcessingConfigurationException extends RuntimeException {
    public InvalidImageProcessingConfigurationException(ImageProcessingConfiguration configuration) {
        super(String.format("Invalid image processing configuration for %s", configuration.getImagePath()));
    }
}
