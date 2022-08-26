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
    private final String inputFilename;
    private final String algorithm;
    private final String algorithmProperties;
    private final String strategy;

    public EditConfigurationData(Long id,
                                 String name,
                                 String description,
                                 String tag,
                                 String inputFilename,
                                 String algorithm,
                                 String algorithmProperties,
                                 String strategy) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tag = tag;
        this.inputFilename = inputFilename;
        this.algorithm = algorithm;
        this.algorithmProperties = algorithmProperties;
        this.strategy = strategy;
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

    public static class Builder {
        private Long id;
        private String name;
        private String description;
        private String tag;
        private String inputFilename;
        private String algorithm;
        private String algorithmProperties;
        private String strategy;

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

        public EditConfigurationData build() {
            return new EditConfigurationData(id, name, description, tag, inputFilename, algorithm, algorithmProperties, strategy);
        }
    }
}
