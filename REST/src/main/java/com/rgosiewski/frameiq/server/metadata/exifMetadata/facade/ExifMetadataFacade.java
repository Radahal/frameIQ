/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.metadata.exifMetadata.facade;

import com.rgosiewski.frameiq.database.implementation.service.ExifMetadataService;
import com.rgosiewski.frameiq.server.common.stereotype.Facade;
import com.rgosiewski.frameiq.server.metadata.exifMetadata.dto.ExifMetadataDTO;
import com.rgosiewski.frameiq.server.metadata.exifMetadata.populator.ExifMetadataDTOFromExifMetadataDataPopulator;

@Facade
public class ExifMetadataFacade {
    private final ExifMetadataService exifMetadataService;
    private final ExifMetadataDTOFromExifMetadataDataPopulator fromExifMetadataDataPopulator;

    public ExifMetadataFacade(ExifMetadataService exifMetadataService, ExifMetadataDTOFromExifMetadataDataPopulator fromExifMetadataDataPopulator) {
        this.exifMetadataService = exifMetadataService;
        this.fromExifMetadataDataPopulator = fromExifMetadataDataPopulator;
    }

    public ExifMetadataDTO getExifMetadata(Long exifMetadataId) {
        return fromExifMetadataDataPopulator.populate(exifMetadataService.getExifMetadata(exifMetadataId));
    }
}
