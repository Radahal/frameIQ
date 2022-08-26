/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.frame.data;

import com.rgosiewski.frameiq.server.common.data.IData;
import com.rgosiewski.frameiq.server.common.data.IDataBuilder;

import java.util.Date;

public class FrameData extends IData {
    private final Long movieId;
    private final Integer ordinal;
    private final String name;
    private final String description;

    public FrameData(Long id, Long creationUsId, Long modificationUsId, Date creationTime, Date modificationTime,
                     Long movieId,
                     Integer ordinal,
                     String name,
                     String description) {
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

    public static final class Builder extends IDataBuilder {
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


        public FrameData build() {
            return new FrameData(id, creationUsId, modificationUsId, creationTime, modificationTime, movieId, ordinal, name, description);
        }

    }
}
