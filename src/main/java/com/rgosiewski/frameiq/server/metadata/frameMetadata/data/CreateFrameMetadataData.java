/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.metadata.frameMetadata.data;

public class CreateFrameMetadataData {
    private final Long frameId;
    private final String metadata;

    public CreateFrameMetadataData(Long frameId, String metadata) {
        this.frameId = frameId;
        this.metadata = metadata;
    }

     public Long getFrameId() {
        return frameId;
    }

    public String getMetadata() {
        return metadata;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long frameId;
        private String metadata;


        public Builder withFrameId(Long frameId) {
            this.frameId = frameId;
            return this;
        }

        public Builder withMetadata(String metadata) {
            this.metadata = metadata;
            return this;
        }

        public CreateFrameMetadataData build() {
            return new CreateFrameMetadataData(frameId, metadata);
        }

    }
}
