/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.configuration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rgosiewski.frameiq.server.common.stereotype.DTO;
import com.sun.istack.NotNull;

@DTO
public class CreateConfigurationDTO {
    @NotNull
    private final String name;
    private final String description;
    private final String tag;
    @NotNull
    private final AlgorithmPropertiesDTO algorithmProperties;

    public CreateConfigurationDTO(@JsonProperty("name") String name,
                                  @JsonProperty("description") String description,
                                  @JsonProperty("tag") String tag,
                                  @JsonProperty("algorithmProperties") AlgorithmPropertiesDTO algorithmProperties) {
        this.name = name;
        this.description = description;
        this.tag = tag;
        this.algorithmProperties = algorithmProperties;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTag() {
        return tag;
    }

    public AlgorithmPropertiesDTO getAlgorithmProperties() {
        return algorithmProperties;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String description;
        private String tag;
        private AlgorithmPropertiesDTO algorithmProperties;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withTag(String tag) {
            this.tag = tag;
            return this;
        }

        public Builder withAlgorithmProperties(AlgorithmPropertiesDTO algorithmProperties) {
            this.algorithmProperties = algorithmProperties;
            return this;
        }

        public CreateConfigurationDTO build() {
            return new CreateConfigurationDTO(name, description, tag, algorithmProperties);
        }
    }
}
