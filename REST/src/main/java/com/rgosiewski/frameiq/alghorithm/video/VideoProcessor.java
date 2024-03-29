/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.alghorithm.video;

import com.rgosiewski.frameiq.alghorithm.exception.ReadVideoException;
import com.rgosiewski.frameiq.server.configuration.data.AlgorithmPropertiesData;
import nu.pattern.OpenCV;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

import java.nio.file.Path;

public class VideoProcessor implements Runnable {
    private final Logger logger = LogManager.getLogger(VideoProcessor.class);
    private final AlgorithmPropertiesData algorithmProperties;
    private final Path outputPath;

    public VideoProcessor(AlgorithmPropertiesData algorithmProperties, Path outputPath) {
        this.algorithmProperties = algorithmProperties;
        this.outputPath = outputPath;
    }

    @Override
    public void run() {
        OpenCV.loadLocally();

        VideoCapture videoCapture = new VideoCapture();
        videoCapture.open(algorithmProperties.getVideoPath().toString());

        int videoLength = (int) videoCapture.get(Videoio.CAP_PROP_FRAME_COUNT);
        int FPS = (int) videoCapture.get(Videoio.CAP_PROP_FPS);

        Mat frame = new Mat();
        if (videoCapture.isOpened()) {
            logger.log(Level.INFO, "Video {} is opened", algorithmProperties.getVideoPath().getFileName());
            logger.log(Level.INFO, "Video has {} frames", videoLength);
            logger.log(Level.INFO, "Video has {} FPS", FPS);
            logger.log(Level.INFO, "Extracting frames...");

            while (videoCapture.read(frame)) {
                int frameNumber = (int) videoCapture.get(Videoio.CAP_PROP_POS_FRAMES);
                logger.log(Level.DEBUG, "Processing frame {} from {}", frameNumber, algorithmProperties.getVideoPath().getFileName().toString());
                Imgcodecs.imwrite(outputPath.resolve(frameNumber+"."+ algorithmProperties.getFileExtension().getExtension()).toString(), frame);
            }
            videoCapture.release();
            logger.log(Level.INFO, "{} frames extracted", videoLength);
        } else {
            throw new ReadVideoException(algorithmProperties.getVideoPath());
        }
    }
}
