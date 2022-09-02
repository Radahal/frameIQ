/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.metadata.exifMetadata.controller;

import com.rgosiewski.frameiq.server.metadata.exifMetadata.dto.ExifMetadataDTO;
import com.rgosiewski.frameiq.server.metadata.exifMetadata.facade.ExifMetadataFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exif")
public class ExifMetadataController {
    private final ExifMetadataFacade exifMetadataFacade;

    public ExifMetadataController(ExifMetadataFacade exifMetadataFacade) {
        this.exifMetadataFacade = exifMetadataFacade;
    }

    @GetMapping("/{exifMetadataId}")
    public ExifMetadataDTO getExifMetadata(@PathVariable Long exifMetadataId) {
        return exifMetadataFacade.getExifMetadata(exifMetadataId);
    }

}
