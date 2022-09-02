/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.metadata.exifMetadata.populator;

import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.metadata.exifMetadata.data.ExifMetadataData;
import com.rgosiewski.frameiq.server.metadata.exifMetadata.dto.ExifMetadataDTO;

@Populator
public class ExifMetadataDTOFromExifMetadataDataPopulator extends DataPopulator<ExifMetadataData, ExifMetadataDTO> {

    @Override
    public ExifMetadataDTO populate(ExifMetadataData exifMetadataData) {
        return ExifMetadataDTO.builder()
                .withMetadata(exifMetadataData.getMetadata())
                .withId(exifMetadataData.getId())
                .withCreationTime(exifMetadataData.getCreationTime())
                .withCreationUsId(exifMetadataData.getCreationUsId())
                .withModificationTime(exifMetadataData.getModificationTime())
                .withModificationUsId(exifMetadataData.getModificationUsId())
                .build();
    }
}
