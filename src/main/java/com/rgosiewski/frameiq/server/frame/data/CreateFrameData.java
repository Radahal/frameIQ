/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.frame.data;

public class CreateFrameData {
    private final Long movieId;
    private final Long processingId;
    private final Integer ordinal;
    private final String name;
    private final String description;

    public CreateFrameData(Long movieId, Long processingId, Integer ordinal, String name, String description) {
        this.movieId = movieId;
        this.processingId = processingId;
        this.ordinal = ordinal;
        this.name = name;
        this.description = description;
    }

    public Long getMovieId() {
        return movieId;
    }

    public Long getProcessingId() {
        return processingId;
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long movieId;
        private Long processingId;
        private Integer ordinal;
        private String name;
        private String description;

        public Builder withMovieId(Long movieId) {
            this.movieId = movieId;
            return this;
        }

        public Builder withProcessingId(Long processingId) {
            this.processingId = processingId;
            return this;
        }

        public Builder withOrdinal(Integer ordinal) {
            this.ordinal = ordinal;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }


        public CreateFrameData build() {
            return new CreateFrameData(movieId, processingId, ordinal, name, description);
        }

    }
}
