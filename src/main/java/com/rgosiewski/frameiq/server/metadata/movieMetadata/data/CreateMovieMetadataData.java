/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.metadata.movieMetadata.data;

public class CreateMovieMetadataData {
    private final Long movieId;
    private final String metadata;

    public CreateMovieMetadataData(Long movieId, String metadata) {
        this.movieId = movieId;
        this.metadata = metadata;
    }

     public Long getMovieId() {
        return movieId;
    }

    public String getMetadata() {
        return metadata;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long movieId;
        private String metadata;


        public Builder withMovieId(Long movieId) {
            this.movieId = movieId;
            return this;
        }

        public Builder withMetadata(String metadata) {
            this.metadata = metadata;
            return this;
        }

        public CreateMovieMetadataData build() {
            return new CreateMovieMetadataData(movieId, metadata);
        }

    }
}
