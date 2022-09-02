/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.movie.data;

public class CreateMovieData {
    private final Long blueprintId;
    private final String name;
    private final String description;

    public CreateMovieData(Long blueprintId,
                           String name,
                           String description) {
        this.blueprintId = blueprintId;
        this.name = name;
        this.description = description;
    }

    public Long getBlueprintId() {
        return blueprintId;
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
        private Long blueprintId;
        private String name;
        private String description;

        public Builder withBlueprintId(Long blueprintId) {
            this.blueprintId = blueprintId;
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


        public CreateMovieData build() {
            return new CreateMovieData(blueprintId, name, description);
        }

    }
}
