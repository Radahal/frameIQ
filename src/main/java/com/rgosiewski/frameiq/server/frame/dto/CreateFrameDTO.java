/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.frame.dto;

public class CreateFrameDTO {
    private final Integer ordinal;
    private final String name;
    private final String description;

    public CreateFrameDTO(Integer ordinal,
                          String name,
                          String description) {
        this.ordinal = ordinal;
        this.name = name;
        this.description = description;
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
        private Integer ordinal;
        private String name;
        private String description;

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

        public CreateFrameDTO build() {
            return new CreateFrameDTO(ordinal, name, description);
        }

    }
}
