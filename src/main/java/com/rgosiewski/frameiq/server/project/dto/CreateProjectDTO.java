/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rgosiewski.frameiq.server.common.stereotype.ValueObject;
import com.sun.istack.NotNull;

@ValueObject
public class CreateProjectDTO {
    @NotNull
    private final String name;
    private final String description;

    public CreateProjectDTO(@JsonProperty("name") String name,
                            @JsonProperty("description") String description) {
        this.name = name;
        this.description = description;
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

    public static class Builder {
        private String name;
        private String description;


        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public CreateProjectDTO build() {
            return new CreateProjectDTO(name, description);
        }
    }
}
