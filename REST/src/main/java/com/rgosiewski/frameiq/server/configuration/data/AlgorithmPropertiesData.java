/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.configuration.data;

import com.rgosiewski.frameiq.alghorithm.enums.Metrics;
import com.rgosiewski.frameiq.server.configuration.enums.Strategy;
import com.rgosiewski.frameiq.workspace.enums.FileExtensions;

import java.nio.file.Path;

public class AlgorithmPropertiesData {
    private final Strategy strategy;
    private final Path videoPath;
    private final FileExtensions fileExtension;
    private final Metrics metric;
    private final double treshold;
    private final boolean removeBlurred;

    public AlgorithmPropertiesData(Strategy strategy, Path videoPath, FileExtensions fileExtension, Metrics metric, double treshold, boolean removeBlurred) {
        this.strategy = strategy;
        this.videoPath = videoPath;
        this.fileExtension = fileExtension;
        this.metric = metric;
        this.treshold = treshold;
        this.removeBlurred = removeBlurred;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public Path getVideoPath() {
        return videoPath;
    }

    public FileExtensions getFileExtension() {
        return fileExtension;
    }

    public Metrics getMetric() {
        return metric;
    }

    public double getTreshold() {
        return treshold;
    }

    public boolean isRemoveBlurred() {
        return removeBlurred;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Strategy strategy;
        private Path videoPath;
        private FileExtensions fileExtension;
        private Metrics metric;
        private double treshold;
        private boolean removeBlurred;

        public Builder withStrategy(Strategy strategy) {
            this.strategy = strategy;
            return this;
        }

        public Builder withVideoPath(Path videoPath) {
            this.videoPath = videoPath;
            return this;
        }

        public Builder withFileExtension(FileExtensions fileExtension) {
            this.fileExtension = fileExtension;
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

        public Builder withRemoveBlurred(boolean removeBlurred) {
            this.removeBlurred = removeBlurred;
            return this;
        }

        public AlgorithmPropertiesData build() {
            return new AlgorithmPropertiesData(strategy, videoPath, fileExtension, metric, treshold, removeBlurred);
        }
    }

}
