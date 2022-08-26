/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.project.populator;

import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.project.data.ProjectData;
import com.rgosiewski.frameiq.server.project.dto.ProjectDTO;

@Populator
public class ProjectDTOFromProjectDataPopulator extends DataPopulator<ProjectData, ProjectDTO> {

    @Override
    public ProjectDTO populate(ProjectData projectData) {
        return ProjectDTO.builder()
                .withId(projectData.getId())
                .withName(projectData.getName())
                .withDescription(projectData.getDescription())
                .build();
    }
}
