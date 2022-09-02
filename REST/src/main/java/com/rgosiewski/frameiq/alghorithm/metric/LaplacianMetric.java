/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.alghorithm.metric;

import com.rgosiewski.frameiq.alghorithm.exception.ImageProcessingException;
import nu.pattern.OpenCV;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfDouble;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.nio.file.Path;

public class LaplacianMetric extends ImageProcessingAlgorithm {
    private final Logger logger = LogManager.getLogger(LaplacianMetric.class);

    @Override
    public double calculateMetric(Path imagePath) {
        OpenCV.loadLocally();
        Mat image = Imgcodecs.imread(imagePath.toString());
        double focalMeasureScore = 0.0;
        try {
            if (!image.empty()) {
                Mat destination = new Mat();
                Mat matGray = new Mat();
                Imgproc.cvtColor(image, matGray, Imgproc.COLOR_BGR2GRAY);
                Imgproc.Laplacian(matGray, destination, CvType.CV_64F);
                MatOfDouble median = new MatOfDouble();
                MatOfDouble std = new MatOfDouble();
                Core.meanStdDev(destination, median, std);
                focalMeasureScore = Math.pow(std.get(0, 0)[0], 2.0);
                logger.info("Focal measure score for image {}: {}", imagePath.getFileName(), focalMeasureScore);
            }
        } catch (Exception e) {
            logger.error("Error calculating focal measure score for image {}", imagePath.getFileName());
            throw new ImageProcessingException(imagePath);
        }
        return focalMeasureScore;
    }
}
