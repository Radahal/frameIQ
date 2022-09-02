/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.metadata.exifMetadata.data;

import com.rgosiewski.frameiq.server.metadata.exifMetadata.enums.MetadataTypes;

public class CreateExifMetadataData {
    private final MetadataTypes metadataType; //?
    private final Long refId; //?
    private final String metadata;

    public CreateExifMetadataData(MetadataTypes metadataType, Long refId, String metadata) {
        this.metadataType = metadataType;
        this.refId = refId;
        this.metadata = metadata;
    }

    public MetadataTypes getMetadataType() {
        return metadataType;
    }

    public Long getRefId() {
        return refId;
    }

    public String getMetadata() {
        return metadata;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private MetadataTypes metadataType;
        private Long refId;
        private String metadata;


        public Builder withMetadataType(MetadataTypes metadataType) {
            this.metadataType = metadataType;
            return this;
        }

        public Builder withRefId(Long refId) {
            this.refId = refId;
            return this;
        }

        public Builder withMetadata(String metadata) {
            this.metadata = metadata;
            return this;
        }

        public CreateExifMetadataData build() {
            return new CreateExifMetadataData(metadataType, refId, metadata);
        }

    }
}
