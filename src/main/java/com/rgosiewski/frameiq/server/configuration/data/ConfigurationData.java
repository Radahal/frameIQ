/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.configuration.data;

import com.rgosiewski.frameiq.server.common.data.IData;
import com.rgosiewski.frameiq.server.common.data.IDataBuilder;

import java.util.Date;

public class ConfigurationData extends IData {
    private final Long projectId;
    private final String name;
    private final String description;
    private final String tag;
    private final AlgorithmPropertiesData algorithmProperties;

    public ConfigurationData(Long id, Long creationUsId, Long modificationUsId, Date creationTime, Date modificationTime,
                             Long configurationId,
                             String name,
                             String description,
                             String tag,
                             AlgorithmPropertiesData algorithmProperties) {
        super(id, creationUsId, modificationUsId, creationTime, modificationTime);
        this.projectId = configurationId;
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

    public AlgorithmPropertiesData getAlgorithmProperties() {
        return algorithmProperties;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends IDataBuilder {
        private Long projectId;
        private String name;
        private String description;
        private String tag;
        private AlgorithmPropertiesData algorithmProperties;

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

        public Builder withAlgorithmProperties(AlgorithmPropertiesData algorithmProperties) {
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

        public ConfigurationData build() {
            return new ConfigurationData(id, creationUsId, modificationUsId, creationTime, modificationTime, projectId, name, description, tag, algorithmProperties);
        }
    }
}
