/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.processing.populator;

import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.processing.data.ProcessingData;
import com.rgosiewski.frameiq.server.processing.dto.ProcessingDTO;

@Populator
public class ProcessingDTOFromProcessingDataPopulator extends DataPopulator<ProcessingData, ProcessingDTO> {

    @Override
    public ProcessingDTO populate(ProcessingData processingData) {
        return ProcessingDTO.builder()
                .withBlueprintId(processingData.getBlueprintId())
                .withState(processingData.getState())
                .withStartTime(processingData.getCreationTime())
                .withEndTime(processingData.getEndTime())
                .withId(processingData.getId())
                .withCreationTime(processingData.getCreationTime())
                .withCreationUsId(processingData.getCreationUsId())
                .withModificationTime(processingData.getModificationTime())
                .withModificationUsId(processingData.getModificationUsId())
                .build();
    }
}
