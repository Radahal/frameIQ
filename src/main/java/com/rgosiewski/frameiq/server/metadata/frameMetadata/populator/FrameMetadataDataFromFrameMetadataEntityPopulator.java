/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.metadata.frameMetadata.populator;

import com.rgosiewski.frameiq.database.implementation.model.FrameMetadataEntity;
import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.metadata.frameMetadata.data.FrameMetadataData;

@Populator
public class FrameMetadataDataFromFrameMetadataEntityPopulator extends DataPopulator<FrameMetadataEntity, FrameMetadataData> {

    @Override
    public FrameMetadataData populate(FrameMetadataEntity entity) {
        return FrameMetadataData.builder()
                .withMetadata(entity.getProcessedMetadata())
                .withExifMetadataId(entity.getExifMetadataId())
                .withId(entity.getId())
                .withCreationTime(entity.getCreationTime())
                .withCreationUsId(entity.getCreationUsId())
                .withModificationTime(entity.getModificationTime())
                .withModificationUsId(entity.getModificationUsId())
                .build();
    }
}
