/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.metadata.exifMetadata.populator;

import com.rgosiewski.frameiq.database.implementation.model.ExifMetadataEntity;
import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.metadata.exifMetadata.data.ExifMetadataData;

@Populator
public class ExifMetadataDataFromExifMetadataEntityPopulator extends DataPopulator<ExifMetadataEntity, ExifMetadataData> {

    @Override
    public ExifMetadataData populate(ExifMetadataEntity entity) {
        return ExifMetadataData.builder()
                .withMetadata(entity.getExifMetadata())
                .withId(entity.getId())
                .withCreationTime(entity.getCreationTime())
                .withCreationUsId(entity.getCreationUsId())
                .withModificationTime(entity.getModificationTime())
                .withModificationUsId(entity.getModificationUsId())
                .build();
    }
}
