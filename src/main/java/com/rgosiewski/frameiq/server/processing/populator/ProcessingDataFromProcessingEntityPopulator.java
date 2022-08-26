/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.processing.populator;

import com.rgosiewski.frameiq.database.implementation.model.ProcessingEntity;
import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.processing.data.ProcessingData;
import com.rgosiewski.frameiq.server.processing.enums.ProcessingStates;

@Populator
public class ProcessingDataFromProcessingEntityPopulator extends DataPopulator<ProcessingEntity, ProcessingData> {

    @Override
    public ProcessingData populate(ProcessingEntity entity) {
        return ProcessingData.builder()
                .withBlueprintId(entity.getBlueprintId())
                .withState(ProcessingStates.fromName(entity.getState()))
                .withStartTime(entity.getCreationTime())
                .withEndTime(entity.getEndTime())
                .withId(entity.getId())
                .withCreationTime(entity.getCreationTime())
                .withCreationUsId(entity.getCreationUsId())
                .withModificationTime(entity.getModificationTime())
                .withModificationUsId(entity.getModificationUsId())
                .build();
    }
}
