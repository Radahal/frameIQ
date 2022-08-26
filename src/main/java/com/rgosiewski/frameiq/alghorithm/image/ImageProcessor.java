/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.alghorithm.image;

import com.rgosiewski.frameiq.alghorithm.configuration.ImageProcessingConfiguration;
import com.rgosiewski.frameiq.alghorithm.exception.InvalidImageProcessingConfigurationException;
import com.rgosiewski.frameiq.alghorithm.metric.ImageProcessingAlgorithm;
import com.rgosiewski.frameiq.alghorithm.metric.ImageProcessingAlgorithmFactory;
import com.rgosiewski.frameiq.alghorithm.model.ExifMetadata;

import java.util.Optional;

public class ImageProcessor implements Runnable {
    private final ImageExifReader imageExifReader;
    private final ImageProcessingConfiguration configuration;

    public ImageProcessor(ImageExifReader imageExifReader, ImageProcessingConfiguration configuration) {
        this.imageExifReader = imageExifReader;
        this.configuration = configuration;
    }

    @Override
    public void run() {
        if (configuration.getImagePath().toFile().exists()) {
            ImageProcessingAlgorithm processingAlgorithm = ImageProcessingAlgorithmFactory.getImageProcessingAlgorithm(configuration);
            double metricValue = processingAlgorithm.calculateMetric();
            Optional<ExifMetadata> exifMetadata = imageExifReader.getExifMetadata(configuration.getImagePath().toFile());
        } else {
            throw new InvalidImageProcessingConfigurationException(configuration);
        }

    }

}
