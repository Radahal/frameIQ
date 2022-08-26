/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.alghorithm.image;

import com.rgosiewski.frameiq.alghorithm.configuration.ImageProcessingConfiguration;
import com.rgosiewski.frameiq.alghorithm.enums.Metrics;
import com.rgosiewski.frameiq.workspace.enums.FileExtensions;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.util.Objects;

@Service
public class FrameReader {
    private final ImageExifReader imageExifReader;

    public FrameReader(ImageExifReader imageExifReader) {
        this.imageExifReader = imageExifReader;
    }

    public void processFrames(Path projectPath, Metrics metric) {
        File[] files = Objects.requireNonNull(projectPath.toFile().listFiles());
        FileExtensions extension = FileExtensions.getByFilename(files[0].getName());
        int frameCount = files.length;
        processFrames(files, metric, 70.0);
    }

    private void processFrames(Path projectPath, int frameCount, FileExtensions imageExtension, Metrics metric, double treshold) {
        for (int frame = 1; frame <= frameCount; frame+=1) {
            Path framePath = projectPath.resolve(frame+"."+imageExtension.getExtension());
            ImageProcessor imageProcessor = new ImageProcessor(imageExifReader, getImageProcessingConfiguration(framePath, imageExtension, metric, treshold));
            imageProcessor.run();
        }
    }


    private void processFrames(File[] files, Metrics metric, double treshold) {
        for (File file : files) {
            FileExtensions fileExtension = FileExtensions.getByFilename(file.getName());
            ImageProcessor imageProcessor = new ImageProcessor(imageExifReader, getImageProcessingConfiguration(file.toPath(), fileExtension, metric, treshold));
            imageProcessor.run();
        }

    }

    private ImageProcessingConfiguration getImageProcessingConfiguration(Path path, FileExtensions extensions, Metrics metrics, double treshold) {
        return ImageProcessingConfiguration.builder()
                .withImagePath(path)
                .withImageExtension(extensions)
                .withMetric(metrics)
                .withTreshold(treshold)
                .build();
    }
}
