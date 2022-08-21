/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.alghorithm.metric;

import com.rgosiewski.frameiq.alghorithm.configuration.ImageProcessingConfiguration;
import org.springframework.stereotype.Service;

@Service
public class ImageProcessingAlgorithmFactory {
    // try injecting database services for storing results

    public static ImageProcessingAlgorithm getImageProcessingAlgorithm(ImageProcessingConfiguration configuration) {
        switch (configuration.getMetric()) {
            case FOCAL_MESURE_SCORE:
                return new LaplacianMetric(configuration.getImagePath(), configuration.getTreshold());
            case FAST_FOURIER_TRANSFORM_SCORE:
                return new FastFourierTransformMetric(configuration.getImagePath());
            default:
                return new LaplacianMetric(configuration.getImagePath(), configuration.getTreshold());
        }
    }
}
