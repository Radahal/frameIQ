/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.blueprint.data;

import com.rgosiewski.frameiq.server.common.data.IData;
import com.rgosiewski.frameiq.server.common.data.IDataBuilder;

import java.util.Date;

public class BlueprintData extends IData {
    private final Long configurationId;
    private final String name;
    private final String tag;
    private final String inputFilename;
    private final String algorithm;
    private final String algorithmProperties;
    private final String strategy;

    public BlueprintData(Long id, Long creationUsId, Long modificationUsId, Date creationTime, Date modificationTime,
                         Long configurationId,
                         String name,
                         String tag,
                         String inputFilename,
                         String algorithm,
                         String algorithmProperties,
                         String strategy) {
        super(id, creationUsId, modificationUsId, creationTime, modificationTime);
        this.configurationId = configurationId;
        this.name = name;
        this.tag = tag;
        this.inputFilename = inputFilename;
        this.algorithm = algorithm;
        this.algorithmProperties = algorithmProperties;
        this.strategy = strategy;
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

    public String getInputFilename() {
        return inputFilename;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public String getAlgorithmProperties() {
        return algorithmProperties;
    }

    public String getStrategy() {
        return strategy;
    }


    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends IDataBuilder {
        private Long configurationId;
        private String name;
        private String tag;
        private String inputFilename;
        private String algorithm;
        private String algorithmProperties;
        private String strategy;

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

        public Builder withInputFilename(String inputFilename) {
            this.inputFilename = inputFilename;
            return this;
        }

        public Builder withAlgorithm(String algorithm) {
            this.algorithm = algorithm;
            return this;
        }

        public Builder withAlgorithmProperties(String algorithmProperties) {
            this.algorithmProperties = algorithmProperties;
            return this;
        }

        public Builder withStrategy(String strategy) {
            this.strategy = strategy;
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
            return new BlueprintData(id, creationUsId, modificationUsId, creationTime, modificationTime, configurationId, name, tag, inputFilename, algorithm, algorithmProperties, strategy);
        }
    }
}
