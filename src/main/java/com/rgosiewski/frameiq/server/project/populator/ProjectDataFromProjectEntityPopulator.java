/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.project.populator;

import com.rgosiewski.frameiq.database.implementation.model.ProjectEntity;
import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.project.data.ProjectData;

@Populator
public class ProjectDataFromProjectEntityPopulator extends DataPopulator<ProjectEntity, ProjectData> {

    @Override
    public ProjectData populate(ProjectEntity iProject) {
        return ProjectData.builder()
                .withName(iProject.getName())
                .withDescription(iProject.getDescription())
                .withId(iProject.getId())
                .withCreationTime(iProject.getCreationTime())
                .withCreationUsId(iProject.getCreationUsId())
                .withModificationTime(iProject.getModificationTime())
                .withModificationUsId(iProject.getModificationUsId())
                .build();
    }
}
