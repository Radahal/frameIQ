/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.configuration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rgosiewski.frameiq.server.common.dto.IDTO;
import com.rgosiewski.frameiq.server.common.dto.IDTOBuilder;
import com.rgosiewski.frameiq.server.common.stereotype.DTO;

import java.util.Date;

@DTO
public class ConfigurationDTO extends IDTO {
    private final Long projectId;
    private final String name;
    private final String description;
    private final String tag;
    private final AlgorithmPropertiesDTO algorithmProperties;

    public ConfigurationDTO(@JsonProperty("id") Long id,
                            @JsonProperty("creationUsId") Long creationUsId,
                            @JsonProperty("modificationUsId") Long modificationUsId,
                            @JsonProperty("creationTime") Date creationTime,
                            @JsonProperty("modificationTime") Date modificationTime,
                            @JsonProperty("projectId") Long projectId,
                            @JsonProperty("name") String name,
                            @JsonProperty("description") String description,
                            @JsonProperty("tag") String tag,
                            @JsonProperty("algorithmProperties") AlgorithmPropertiesDTO algorithmProperties) {
        super(id, creationUsId, modificationUsId, creationTime, modificationTime);
        this.projectId = projectId;
        this.name = name;
        this.description = description;
        this.tag = tag;
        this.algorithmProperties = algorithmProperties;
    }

    public Long getProjectId() {
        return projectId;
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

    public static class Builder extends IDTOBuilder {
        private Long projectId;
        private String name;
        private String description;
        private String tag;
        private AlgorithmPropertiesDTO algorithmProperties;

        public Builder withProjectId(Long projectId) {
            this.projectId = projectId;
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

        public ConfigurationDTO build() {
            return new ConfigurationDTO(id, creationUsId, modificationUsId, creationTime, modificationTime, projectId, name, description, tag, algorithmProperties);
        }
    }
}
