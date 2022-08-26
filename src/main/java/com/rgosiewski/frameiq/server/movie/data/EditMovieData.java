/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.movie.data;

public class EditMovieData {
    private final Long movieId;
    private final String name;
    private final String description;

    public EditMovieData(Long movieId,
                         String name,
                         String description) {
        this.movieId = movieId;
        this.name = name;
        this.description = description;
    }

    public Long getMovieId() {
        return movieId;
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
        private String name;
        private String description;

        public Builder withMovieId(Long movieId) {
            this.movieId = movieId;
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

        public EditMovieData build() {
            return new EditMovieData(movieId, name, description);
        }

    }
}
