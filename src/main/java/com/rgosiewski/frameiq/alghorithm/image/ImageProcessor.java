/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.alghorithm.image;

import com.rgosiewski.frameiq.alghorithm.configuration.ImageProcessingConfiguration;
import com.rgosiewski.frameiq.alghorithm.exception.InvalidImageProcessingConfigurationException;
import com.rgosiewski.frameiq.alghorithm.metric.ImageProcessingAlgorithm;
import com.rgosiewski.frameiq.alghorithm.metric.ImageProcessingAlgorithmFactory;

public class ImageProcessor implements Runnable {
    private final ImageProcessingConfiguration configuration;

    public ImageProcessor(ImageProcessingConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void run() {
        if (configuration.getImagePath().toFile().exists()) {
            ImageProcessingAlgorithm processingAlgorithm = ImageProcessingAlgorithmFactory.getImageProcessingAlgorithm(configuration);
            double metricValue = processingAlgorithm.calculateMetric();
        } else {
            throw new InvalidImageProcessingConfigurationException(configuration);
        }

    }

}
