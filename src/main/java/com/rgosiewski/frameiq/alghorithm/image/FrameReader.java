/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.alghorithm.image;

import com.rgosiewski.frameiq.alghorithm.configuration.ImageProcessingConfiguration;
import com.rgosiewski.frameiq.alghorithm.enums.Metrics;
import com.rgosiewski.frameiq.repository.enums.FileExtensions;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.util.Objects;

@Service
public class FrameReader {

    public void processFrames(Path projectPath, Metrics metric) {
        File[] files = Objects.requireNonNull(projectPath.toFile().listFiles());
        FileExtensions extension = FileExtensions.getByFilename(files[0].getName());
        int frameCount = files.length;
        processFrames(projectPath, frameCount, extension, metric, 50.0);
    }

    private void processFrames(Path projectPath, int frameCount, FileExtensions imageExtension, Metrics metric, double treshold) {

        for (int frame = 1; frame <= frameCount; frame+=50) {
            Path framePath = projectPath.resolve(frame+"."+imageExtension.getExtension());
            ImageProcessor imageProcessor = new ImageProcessor(getImageProcessingConfiguration(framePath, imageExtension, metric, treshold));
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
