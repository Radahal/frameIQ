/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.project.populator;

import com.rgosiewski.frameiq.server.common.populator.ByIdDataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.project.data.EditProjectData;
import com.rgosiewski.frameiq.server.project.dto.EditProjectDTO;

@Populator
public class EditProjectDataFromEditProjectDTOPopulator extends ByIdDataPopulator<EditProjectDTO, EditProjectData> {

    @Override
    public EditProjectData populate(Long sourceId, EditProjectDTO editProjectDTO) {
        return EditProjectData.builder()
                .withId(sourceId)
                .withName(editProjectDTO.getName())
                .withDescription(editProjectDTO.getDescription())
                .build();
    }
}
