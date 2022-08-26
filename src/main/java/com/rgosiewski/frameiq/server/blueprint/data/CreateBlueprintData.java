/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.blueprint.data;

public class CreateBlueprintData {
    private final Long projectId;
    private final Long configurationId;

    public CreateBlueprintData(Long projectId, Long configurationId) {
        this.projectId = projectId;
        this.configurationId = configurationId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public Long getConfigurationId() {
        return configurationId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder  {
        private Long projectId;
        private Long configurationId;

        public Builder withProjectId(Long projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder withConfigurationId(Long configurationId) {
            this.configurationId = configurationId;
            return this;
        }

        public CreateBlueprintData build() {
            return new CreateBlueprintData(projectId, configurationId);
        }
    }
}
