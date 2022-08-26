/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.frame.data;

public class EditFrameData {
    private final Long frameId;
    private final String name;
    private final String description;

    public EditFrameData(Long frameId,
                         String name,
                         String description) {
        this.frameId = frameId;
        this.name = name;
        this.description = description;
    }

    public Long getFrameId() {
        return frameId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long frameId;
        private String name;
        private String description;

        public Builder withFrameId(Long frameId) {
            this.frameId = frameId;
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

        public EditFrameData build() {
            return new EditFrameData(frameId, name, description);
        }

    }
}
