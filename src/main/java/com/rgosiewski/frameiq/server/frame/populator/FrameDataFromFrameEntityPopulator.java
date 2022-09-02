/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.frame.populator;

import com.rgosiewski.frameiq.database.implementation.model.FrameEntity;
import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.frame.data.FrameData;

@Populator
public class FrameDataFromFrameEntityPopulator extends DataPopulator<FrameEntity, FrameData> {

    @Override
    public FrameData populate(FrameEntity entity) {
        return FrameData.builder()
                .withMovieId(entity.getMovieId())
                .withProcessingId(entity.getProcessingId())
                .withOrdinal(entity.getOrdinal())
                .withName(entity.getName())
                .withDescription(entity.getDescription())
                .withId(entity.getId())
                .withCreationTime(entity.getCreationTime())
                .withCreationUsId(entity.getCreationUsId())
                .withModificationTime(entity.getModificationTime())
                .withModificationUsId(entity.getModificationUsId())
                .build();
    }
}
