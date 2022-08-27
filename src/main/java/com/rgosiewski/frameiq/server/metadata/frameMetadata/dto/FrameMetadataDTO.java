/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.metadata.frameMetadata.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rgosiewski.frameiq.alghorithm.model.FrameProcessedMetadata;
import com.rgosiewski.frameiq.server.common.dto.IDTO;
import com.rgosiewski.frameiq.server.common.dto.IDTOBuilder;
import com.rgosiewski.frameiq.server.common.stereotype.ValueObject;

import java.util.Date;

@ValueObject
public class FrameMetadataDTO extends IDTO {
    private final Long exifMetadataId;
    private final FrameProcessedMetadata metadata;

    public FrameMetadataDTO(@JsonProperty("id") Long id,
                            @JsonProperty("creationUsId") Long creationUsId,
                            @JsonProperty("modificationUsId") Long modificationUsId,
                            @JsonProperty("creationTime") Date creationTime,
                            @JsonProperty("modificationTime") Date modificationTime,
                            @JsonProperty("exifMetadataId") Long exifMetadataId,
                            @JsonProperty("metadata") FrameProcessedMetadata metadata) {
        super(id, creationUsId, modificationUsId, creationTime, modificationTime);
        this.exifMetadataId = exifMetadataId;
        this.metadata = metadata;
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

    public static final class Builder extends IDTOBuilder {
        private Long exifMetadataId;
        private FrameProcessedMetadata metadata;

        public Builder withExifMetadataId(Long exifMetadataId) {
            this.exifMetadataId = exifMetadataId;
            return this;
        }

        public Builder withMetadata(FrameProcessedMetadata metadata) {
            this.metadata = metadata;
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

        public FrameMetadataDTO build() {
            return new FrameMetadataDTO(id, creationUsId, modificationUsId, creationTime, modificationTime, exifMetadataId, metadata);
        }

    }
}
