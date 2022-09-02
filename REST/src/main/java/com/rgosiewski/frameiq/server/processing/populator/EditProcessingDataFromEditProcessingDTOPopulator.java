/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.processing.populator;

import com.rgosiewski.frameiq.server.common.populator.ByIdDataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.processing.data.EditProcessingData;
import com.rgosiewski.frameiq.server.processing.dto.EditProcessingDTO;

@Populator
public class EditProcessingDataFromEditProcessingDTOPopulator extends ByIdDataPopulator<EditProcessingDTO, EditProcessingData> {

    @Override
    public EditProcessingData populate(Long sourceId, EditProcessingDTO editProcessingDTO) {
        return EditProcessingData.builder()
                .withId(sourceId)
                .withBlueprintId(editProcessingDTO.getBlueprintId())
                .withState(editProcessingDTO.getState())
                .build();
    }
}
