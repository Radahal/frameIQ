/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.blueprint.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rgosiewski.frameiq.server.common.dto.IDTO;
import com.rgosiewski.frameiq.server.common.dto.IDTOBuilder;
import com.rgosiewski.frameiq.server.common.stereotype.DTO;
import com.rgosiewski.frameiq.server.configuration.dto.AlgorithmPropertiesDTO;

import java.util.Date;

@DTO
public class BlueprintDTO extends IDTO {
    private final Long configurationId;
    private final String name;
    private final String tag;
    private final AlgorithmPropertiesDTO algorithmProperties;

    public BlueprintDTO(@JsonProperty("id") Long id,
                        @JsonProperty("creationUsId") Long creationUsId,
                        @JsonProperty("modificationUsId") Long modificationUsId,
                        @JsonProperty("creationTime") Date creationTime,
                        @JsonProperty("modificationTime") Date modificationTime,
                        @JsonProperty("configurationId") Long configurationId,
                        @JsonProperty("name") String name,
                        @JsonProperty("tag") String tag,
                        @JsonProperty("algorithmProperties") AlgorithmPropertiesDTO algorithmProperties) {
        super(id, creationUsId, modificationUsId, creationTime, modificationTime);
        this.configurationId = configurationId;
        this.name = name;
        this.tag = tag;
        this.algorithmProperties = algorithmProperties;
    }

    public Long getConfigurationId() {
        return configurationId;
    }

    public String getName() {
        return name;
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

    public static class Builder extends IDTOBuilder {
        private Long configurationId;
        private String name;
        private String tag;
        private AlgorithmPropertiesDTO algorithmProperties;

        public Builder withConfigurationId(Long configurationId) {
            this.configurationId = configurationId;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
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

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withCreationUsId(Long creationUsId) {
            this.creationUsId = creationUsId;
            return this;
        }

        public Builder withModificationUsId(Long modificationUsId) {
            this.modificationUsId = modificationUsId;
            return this;
        }

        public Builder withCreationTime(Date creationTime) {
            this.creationTime = creationTime;
            return this;
        }

        public Builder withModificationTime(Date modificationTime) {
            this.modificationTime = modificationTime;
            return this;
        }

        public BlueprintDTO build() {
            return new BlueprintDTO(id, creationUsId, modificationUsId, creationTime, modificationTime, configurationId, name, tag, algorithmProperties);
        }
    }
}
