/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.processing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rgosiewski.frameiq.server.common.stereotype.DTO;
import com.rgosiewski.frameiq.server.processing.enums.ProcessingStates;

@DTO
public class EditProcessingDTO {
    private final Long blueprintId;
    private final ProcessingStates state;

    public EditProcessingDTO(@JsonProperty("blueprintId") Long blueprintId,
                             @JsonProperty("state") ProcessingStates state) {
        this.blueprintId = blueprintId;
        this.state = state;
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
        private Long blueprintId;
        private ProcessingStates state;

        public Builder withBlueprintId(Long blueprintId) {
            this.blueprintId = blueprintId;
            return this;
        }

        public Builder withState(ProcessingStates state) {
            this.state = state;
            return this;
        }

        public EditProcessingDTO build() {
            return new EditProcessingDTO(blueprintId, state);
        }

    }
}
