/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.processing.data;

import com.rgosiewski.frameiq.server.processing.enums.ProcessingStates;

import java.util.Date;

public class CreateProcessingData {
    private final Long blueprintId;
    private final ProcessingStates state;
    private final Date startTime;

    public CreateProcessingData(Long blueprintId, ProcessingStates state, Date startTime) {
        this.blueprintId = blueprintId;
        this.state = state;
        this.startTime = startTime;
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

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long blueprintId;
        private ProcessingStates state;
        private Date startTime;

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

        public CreateProcessingData build() {
            return new CreateProcessingData(blueprintId, state, startTime);
        }

    }
}
