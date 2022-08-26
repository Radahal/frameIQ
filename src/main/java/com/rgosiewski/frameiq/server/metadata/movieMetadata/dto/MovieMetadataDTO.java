/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.metadata.movieMetadata.dto;

import com.rgosiewski.frameiq.server.common.dto.IDTO;
import com.rgosiewski.frameiq.server.common.dto.IDTOBuilder;

import java.util.Date;

public class MovieMetadataDTO extends IDTO {
    private final Long exifMetadataId;
    private final String metadata;

    public MovieMetadataDTO(Long id, Long creationUsId, Long modificationUsId, Date creationTime, Date modificationTime,
                            Long exifMetadataId, String metadata) {
        super(id, creationUsId, modificationUsId, creationTime, modificationTime);
        this.exifMetadataId = exifMetadataId;
        this.metadata = metadata;
    }

    public Long getExifMetadataId() {
        return exifMetadataId;
    }

    public String getMetadata() {
        return metadata;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends IDTOBuilder {
        private Long exifMetadataId;
        private String metadata;

        public Builder withExifMetadataId(Long exifMetadataId) {
            this.exifMetadataId = exifMetadataId;
            return this;
        }

        public Builder withMetadata(String metadata) {
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

        public MovieMetadataDTO build() {
            return new MovieMetadataDTO(id, creationUsId, modificationUsId, creationTime, modificationTime, exifMetadataId, metadata);
        }

    }
}
