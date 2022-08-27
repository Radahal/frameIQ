/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.alghorithm.model;

public class FrameProcessedMetadata {
    private final double score;

    public FrameProcessedMetadata(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private double score;

        public Builder withScore(double score) {
            this.score = score;
            return this;
        }

        public FrameProcessedMetadata build() {
            return new FrameProcessedMetadata(score);
        }
    }
}
