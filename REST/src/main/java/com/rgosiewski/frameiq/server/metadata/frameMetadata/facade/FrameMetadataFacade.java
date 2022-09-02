/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.metadata.frameMetadata.facade;

import com.rgosiewski.frameiq.database.implementation.service.FrameMetadataService;
import com.rgosiewski.frameiq.server.common.stereotype.Facade;
import com.rgosiewski.frameiq.server.metadata.frameMetadata.dto.FrameMetadataDTO;
import com.rgosiewski.frameiq.server.metadata.frameMetadata.populator.FrameMetadataDTOFromFrameMetadataDataPopulator;

import java.util.List;

@Facade
public class FrameMetadataFacade {
    private final FrameMetadataService frameMetadataService;
    private final FrameMetadataDTOFromFrameMetadataDataPopulator fromFrameMetadataDataPopulator;

    public FrameMetadataFacade(FrameMetadataService frameMetadataService,
                               FrameMetadataDTOFromFrameMetadataDataPopulator fromFrameMetadataDataPopulator) {
        this.frameMetadataService = frameMetadataService;
        this.fromFrameMetadataDataPopulator = fromFrameMetadataDataPopulator;
    }

    public FrameMetadataDTO getFrameMetadata(Long frameMetadataId) {
        return fromFrameMetadataDataPopulator.populate(frameMetadataService.getFrameMetadata(frameMetadataId));
    }

    public List<FrameMetadataDTO> listAllByFrameId(Long frameId) {
        return fromFrameMetadataDataPopulator.populateAll(frameMetadataService.listFrameMetadata(frameId));
    }

}
