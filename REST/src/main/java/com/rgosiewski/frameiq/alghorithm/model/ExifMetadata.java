/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.alghorithm.model;

public class ExifMetadata {
    private final String metadata;

    public ExifMetadata(String metadata) {
        this.metadata = metadata;
    }

    public String getMetadata() {
        return metadata;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String metadata;

        public Builder withMetadata(String metadata) {
            this.metadata = metadata;
            return this;
        }

        public ExifMetadata build() {
            return new ExifMetadata(metadata);
        }
    }
}
