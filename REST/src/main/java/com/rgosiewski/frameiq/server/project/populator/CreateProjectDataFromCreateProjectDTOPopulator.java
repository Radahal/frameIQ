/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.project.populator;

import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.project.data.CreateProjectData;
import com.rgosiewski.frameiq.server.project.dto.CreateProjectDTO;

@Populator
public class CreateProjectDataFromCreateProjectDTOPopulator extends DataPopulator<CreateProjectDTO, CreateProjectData> {

    @Override
    public CreateProjectData populate(CreateProjectDTO createProjectDTO) {
        return CreateProjectData.builder()
                .withName(createProjectDTO.getName())
                .withDescription(createProjectDTO.getDescription())
                .build();
    }
}
