/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.blueprint.dto;

public class CreateBlueprintDTO {
    private final Long configurationId;

    public CreateBlueprintDTO(Long configurationId) {
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
