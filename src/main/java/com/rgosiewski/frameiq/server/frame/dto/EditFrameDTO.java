/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.frame.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rgosiewski.frameiq.server.common.stereotype.ValueObject;

@ValueObject
public class EditFrameDTO {
    private final String name;
    private final String description;

    public EditFrameDTO(@JsonProperty("name") String name,
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

    public static final class Builder {
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

        public EditFrameDTO build() {
            return new EditFrameDTO(name, description);
        }

    }
}
