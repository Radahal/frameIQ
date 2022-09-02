/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.blueprint.data;

import com.rgosiewski.frameiq.server.common.data.IData;
import com.rgosiewski.frameiq.server.common.data.IDataBuilder;
import com.rgosiewski.frameiq.server.configuration.data.AlgorithmPropertiesData;

import java.util.Date;

public class BlueprintData extends IData {
    private final Long configurationId;
    private final String name;
    private final String tag;
    private final AlgorithmPropertiesData algorithmProperties;

    public BlueprintData(Long id, Long creationUsId, Long modificationUsId, Date creationTime, Date modificationTime,
                         Long configurationId,
                         String name,
                         String tag,
                         AlgorithmPropertiesData algorithmProperties) {
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

    public AlgorithmPropertiesData getAlgorithmProperties() {
        return algorithmProperties;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends IDataBuilder {
        private Long configurationId;
        private String name;
        private String tag;
        private AlgorithmPropertiesData algorithmProperties;

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

        public BlueprintData build() {
            return new BlueprintData(id, creationUsId, modificationUsId, creationTime, modificationTime, configurationId, name, tag, algorithmProperties);
        }
    }
}
