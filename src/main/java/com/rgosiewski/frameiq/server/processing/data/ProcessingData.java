/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.processing.data;

import com.rgosiewski.frameiq.server.common.data.IData;
import com.rgosiewski.frameiq.server.common.data.IDataBuilder;
import com.rgosiewski.frameiq.server.processing.enums.ProcessingStates;

import java.util.Date;

public class ProcessingData extends IData {
    private final Long blueprintId;
    private final ProcessingStates state;
    private final Date startTime;
    private final Date endTime;

    public ProcessingData(Long id, Long creationUsId, Long modificationUsId, Date creationTime, Date modificationTime,
                          Long blueprintId,
                          ProcessingStates state,
                          Date startTime,
                          Date endTime) {
        super(id, creationUsId, modificationUsId, creationTime, modificationTime);
        this.blueprintId = blueprintId;
        this.state = state;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getBlueprintId() {
        return blueprintId;
    }

    public ProcessingStates getState() {
        return state;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends IDataBuilder {
        private Long blueprintId;
        private ProcessingStates state;
        private Date startTime;
        private Date endTime;

        public Builder withBlueprintId(Long blueprintId) {
            this.blueprintId = blueprintId;
            return this;
        }

        public Builder withState(ProcessingStates state) {
            this.state = state;
            return this;
        }

        public Builder withStartTime(Date startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder withEndTime(Date endTime) {
            this.endTime = endTime;
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


        public ProcessingData build() {
            return new ProcessingData(id, creationUsId, modificationUsId, creationTime, modificationTime, blueprintId, state, startTime, endTime);
        }

    }
}
