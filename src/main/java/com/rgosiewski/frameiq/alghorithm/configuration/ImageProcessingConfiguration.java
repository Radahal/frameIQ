/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.alghorithm.configuration;

import com.rgosiewski.frameiq.alghorithm.enums.Metrics;
import com.rgosiewski.frameiq.workspace.enums.FileExtensions;

import java.nio.file.Path;

public class ImageProcessingConfiguration {
    private final int projectId;
    private final Path imagePath;
    private final FileExtensions imageExtension;
    private final Metrics metric;
    private final double treshold;

    public ImageProcessingConfiguration(int projectId, Path imagePath, FileExtensions imageExtension, Metrics metric, double treshold) {
        this.projectId = projectId;
        this.imagePath = imagePath;
        this.imageExtension = imageExtension;
        this.metric = metric;
        this.treshold = treshold;
    }

    public int getProjectId() {
        return projectId;
    }

    public Path getImagePath() {
        return imagePath;
    }

    public FileExtensions getImageExtension() {
        return imageExtension;
    }

    public Metrics getMetric() {
        return metric;
    }

    public double getTreshold() {
        return treshold;
    }

    public static Builder builder() {
        return new Builder();
    }

    public final static class Builder {
        private int projectId;
        private Path imagePath;
        private FileExtensions imageExtension;
        private Metrics metric;
        private double treshold = 100.0;

        public Builder withProjectId(int projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder withImagePath(Path imagePath) {
            this.imagePath = imagePath;
            return this;
        }

        public Builder withImageExtension(FileExtensions imageExtension) {
            this.imageExtension = imageExtension;
            return this;
        }

        public Builder withMetric(Metrics metric) {
            this.metric = metric;
            return this;
        }

        public Builder withTreshold(double treshold) {
            this.treshold = treshold;
            return this;
        }

        public ImageProcessingConfiguration build() {
            return new ImageProcessingConfiguration(projectId, imagePath, imageExtension, metric, treshold);
        }
    }
}
