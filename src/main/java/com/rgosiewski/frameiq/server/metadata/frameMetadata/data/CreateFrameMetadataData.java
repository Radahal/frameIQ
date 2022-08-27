/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.metadata.frameMetadata.data;

import com.rgosiewski.frameiq.alghorithm.model.FrameProcessedMetadata;

public class CreateFrameMetadataData {
    private final Long frameId;
    private final Long exifMetadataId;
    private final FrameProcessedMetadata metadata;

    public CreateFrameMetadataData(Long frameId,
                                   Long exifMetadataId,
                                   FrameProcessedMetadata metadata) {
        this.frameId = frameId;
        this.exifMetadataId = exifMetadataId;
        this.metadata = metadata;
    }

    public Long getFrameId() {
        return frameId;
    }

    public Long getExifMetadataId() {
        return exifMetadataId;
    }

    public FrameProcessedMetadata getMetadata() {
        return metadata;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long frameId;
        private Long exifMetadataId;
        private FrameProcessedMetadata metadata;

        public Builder withFrameId(Long frameId) {
            this.frameId = frameId;
            return this;
        }

        public Builder withExifMetadataId(Long exifMetadataId) {
            this.exifMetadataId = exifMetadataId;
            return this;
        }

        public Builder withMetadata(FrameProcessedMetadata metadata) {
            this.metadata = metadata;
            return this;
        }

        public CreateFrameMetadataData build() {
            return new CreateFrameMetadataData(frameId, exifMetadataId, metadata);
        }

    }
}
