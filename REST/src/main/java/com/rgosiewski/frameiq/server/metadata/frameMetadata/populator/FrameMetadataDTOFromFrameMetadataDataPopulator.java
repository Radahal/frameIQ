/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.metadata.frameMetadata.populator;

import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.metadata.frameMetadata.data.FrameMetadataData;
import com.rgosiewski.frameiq.server.metadata.frameMetadata.dto.FrameMetadataDTO;

@Populator
public class FrameMetadataDTOFromFrameMetadataDataPopulator extends DataPopulator<FrameMetadataData, FrameMetadataDTO> {

    @Override
    public FrameMetadataDTO populate(FrameMetadataData frameMetadataData) {
        return FrameMetadataDTO.builder()
                .withMetadata(frameMetadataData.getMetadata())
                .withExifMetadataId(frameMetadataData.getExifMetadataId())
                .withId(frameMetadataData.getId())
                .withCreationTime(frameMetadataData.getCreationTime())
                .withCreationUsId(frameMetadataData.getCreationUsId())
                .withModificationTime(frameMetadataData.getModificationTime())
                .withModificationUsId(frameMetadataData.getModificationUsId())
                .build();
    }
}
