/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.processing.data;

import com.rgosiewski.frameiq.server.processing.enums.ProcessingStates;

public class EditProcessingData {
    private final Long id;
    private final Long blueprintId;
    private final ProcessingStates state;

    public EditProcessingData(Long id, Long blueprintId, ProcessingStates state) {
        this.id = id;
        this.blueprintId = blueprintId;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public Long getBlueprintId() {
        return blueprintId;
    }

    public ProcessingStates getState() {
        return state;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private Long blueprintId;
        private ProcessingStates state;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withBlueprintId(Long blueprintId) {
            this.blueprintId = blueprintId;
            return this;
        }

        public Builder withState(ProcessingStates state) {
            this.state = state;
            return this;
        }

        public EditProcessingData build() {
            return new EditProcessingData(id, blueprintId, state);
        }

    }
}
