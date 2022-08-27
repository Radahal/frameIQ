/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.alghorithm.metric;

import com.rgosiewski.frameiq.alghorithm.enums.Metrics;
import org.springframework.stereotype.Service;

@Service
public class ImageProcessingAlgorithmFactory {
    // try injecting database services for storing results

    public static ImageProcessingAlgorithm getImageProcessingAlgorithm(Metrics metric) {
        switch (metric) {
            case FOCAL_MESURE_SCORE:
                return new LaplacianMetric();
            case FAST_FOURIER_TRANSFORM_SCORE:
                return new FastFourierTransformMetric();
            default:
                return new LaplacianMetric();
        }
    }
}
