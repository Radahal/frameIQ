/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.movie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rgosiewski.frameiq.server.common.dto.IDTO;
import com.rgosiewski.frameiq.server.common.dto.IDTOBuilder;
import com.rgosiewski.frameiq.server.common.stereotype.DTO;

import java.util.Date;

@DTO
public class MovieDTO extends IDTO {
    private final Long blueprintId;
    private final String name;
    private final String description;

    public MovieDTO(@JsonProperty("id") Long id,
                    @JsonProperty("creationUsId") Long creationUsId,
                    @JsonProperty("modificationUsId") Long modificationUsId,
                    @JsonProperty("creationTime") Date creationTime,
                    @JsonProperty("modificationTime") Date modificationTime,
                    @JsonProperty("blueprintId") Long blueprintId,
                    @JsonProperty("name") String name,
                    @JsonProperty("description") String description) {
        super(id, creationUsId, modificationUsId, creationTime, modificationTime);
        this.blueprintId = blueprintId;
        this.name = name;
        this.description = description;
    }

    public Long getBlueprintId() {
        return blueprintId;
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

    public static final class Builder extends IDTOBuilder {
        private Long blueprintId;
        private String name;
        private String description;

        public Builder withBlueprintId(Long blueprintId) {
            this.blueprintId = blueprintId;
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


        public MovieDTO build() {
            return new MovieDTO(id, creationUsId, modificationUsId, creationTime, modificationTime, blueprintId, name, description);
        }

    }
}
