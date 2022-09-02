/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.configuration.data;

public class CreateConfigurationData {
    private final Long projectId;
    private final String name;
    private final String description;
    private final String tag;
    private final AlgorithmPropertiesData algorithmProperties;

    public CreateConfigurationData(Long projectId,
                             String name,
                             String description,
                             String tag,
                             AlgorithmPropertiesData algorithmProperties) {
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

    public AlgorithmPropertiesData getAlgorithmProperties() {
        return algorithmProperties;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
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

        public CreateConfigurationData build() {
            return new CreateConfigurationData(projectId, name, description, tag, algorithmProperties);
        }
    }
}
