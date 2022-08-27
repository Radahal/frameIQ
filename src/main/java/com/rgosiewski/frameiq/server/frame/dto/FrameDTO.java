/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.frame.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rgosiewski.frameiq.server.common.dto.IDTO;
import com.rgosiewski.frameiq.server.common.dto.IDTOBuilder;
import com.rgosiewski.frameiq.server.common.stereotype.ValueObject;

import java.util.Date;

@ValueObject
public class FrameDTO extends IDTO {
    private final Long movieId;
    private final Integer ordinal;
    private final String name;
    private final String description;;

    public FrameDTO(@JsonProperty("id") Long id,
                    @JsonProperty("creationUsId") Long creationUsId,
                    @JsonProperty("modificationUsId") Long modificationUsId,
                    @JsonProperty("creationTime") Date creationTime,
                    @JsonProperty("modificationTime") Date modificationTime,
                    @JsonProperty("movieId") Long movieId,
                    @JsonProperty("ordinal") Integer ordinal,
                    @JsonProperty("name") String name,
                    @JsonProperty("description") String description) {
        super(id, creationUsId, modificationUsId, creationTime, modificationTime);
        this.movieId = movieId;
        this.ordinal = ordinal;
        this.name = name;
        this.description = description;
    }

    public Long getMovieId() {
        return movieId;
    }

    public Integer getOrdinal() {
        return ordinal;
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
        private Long movieId;
        private Integer ordinal;
        private String name;
        private String description;

        public Builder withMovieId(Long movieId) {
            this.movieId = movieId;
            return this;
        }

        public Builder withOrdinal(Integer ordinal) {
            this.ordinal = ordinal;
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


        public FrameDTO build() {
            return new FrameDTO(id, creationUsId, modificationUsId, creationTime, modificationTime, movieId, ordinal, name, description);
        }

    }
}
