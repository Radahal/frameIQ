/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.configuration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rgosiewski.frameiq.alghorithm.enums.Metrics;
import com.rgosiewski.frameiq.server.common.stereotype.ValueObject;
import com.rgosiewski.frameiq.server.configuration.enums.Strategy;
import com.rgosiewski.frameiq.workspace.enums.FileExtensions;
import com.sun.istack.NotNull;

@ValueObject
public class AlgorithmPropertiesDTO {
    @NotNull
    private final Strategy strategy;
    private final String videoPath;
    private final FileExtensions fileExtension;
    @NotNull
    private final Metrics metric;
    @NotNull
    private final double treshold;
    private final boolean removeBlurred;

    public AlgorithmPropertiesDTO(@JsonProperty("strategy") Strategy strategy,
                                  @JsonProperty("videoPath") String videoPath,
                                  @JsonProperty("fileExtension") FileExtensions fileExtension,
                                  @JsonProperty("metric") Metrics metric,
                                  @JsonProperty("treshold") double treshold,
                                  @JsonProperty("removeBlurred") boolean removeBlurred) {
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

    public String getVideoPath() {
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
        private String videoPath;
        private FileExtensions fileExtension;
        private Metrics metric;
        private double treshold;
        private boolean removeBlurred;

        public Builder withStrategy(Strategy strategy) {
            this.strategy = strategy;
            return this;
        }

        public Builder withVideoPath(String videoPath) {
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

        public AlgorithmPropertiesDTO build() {
            return new AlgorithmPropertiesDTO(strategy, videoPath, fileExtension, metric, treshold, removeBlurred);
        }
    }

}
