/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.configuration.data;

public class EditConfigurationData {
    private final Long id;
    private final String name;
    private final String description;
    private final String tag;
    private final AlgorithmPropertiesData algorithmProperties;

    public EditConfigurationData(Long id, String name, String description, String tag, AlgorithmPropertiesData algorithmProperties) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tag = tag;
        this.algorithmProperties = algorithmProperties;
    }

    public Long getId() {
        return id;
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

    public static class Builder {
        private Long id;
        private String name;
        private String description;
        private String tag;
        private AlgorithmPropertiesData algorithmProperties;

        public Builder withId(Long id) {
            this.id = id;
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

        public EditConfigurationData build() {
            return new EditConfigurationData(id, name, description, tag, algorithmProperties);
        }
    }
}
