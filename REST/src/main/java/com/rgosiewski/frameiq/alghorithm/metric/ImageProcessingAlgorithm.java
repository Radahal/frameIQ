/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.alghorithm.metric;

import java.nio.file.Path;

public abstract class ImageProcessingAlgorithm {
    public abstract double calculateMetric(Path imagePath);
}