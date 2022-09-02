/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.blueprint.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rgosiewski.frameiq.server.common.stereotype.DTO;
import com.sun.istack.NotNull;

@DTO
public class CreateBlueprintDTO {
    @NotNull
    private final Long configurationId;

    public CreateBlueprintDTO(@JsonProperty("configurationId") Long configurationId) {
        this.configurationId = configurationId;
    }

    public Long getConfigurationId() {
        return configurationId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder  {
        private Long configurationId;

        public Builder withConfigurationId(Long configurationId) {
            this.configurationId = configurationId;
            return this;
        }

        public CreateBlueprintDTO build() {
            return new CreateBlueprintDTO(configurationId);
        }
    }
}
