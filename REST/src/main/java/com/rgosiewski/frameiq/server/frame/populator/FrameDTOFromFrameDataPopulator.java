/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.frame.populator;

import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.frame.data.FrameData;
import com.rgosiewski.frameiq.server.frame.dto.FrameDTO;

@Populator
public class FrameDTOFromFrameDataPopulator extends DataPopulator<FrameData, FrameDTO> {

    @Override
    public FrameDTO populate(FrameData frameData) {
        return FrameDTO.builder()
                .withMovieId(frameData.getMovieId())
                .withProcessingId(frameData.getProcessingId())
                .withOrdinal(frameData.getOrdinal())
                .withName(frameData.getName())
                .withDescription(frameData.getDescription())
                .withId(frameData.getId())
                .withCreationTime(frameData.getCreationTime())
                .withCreationUsId(frameData.getCreationUsId())
                .withModificationTime(frameData.getModificationTime())
                .withModificationUsId(frameData.getModificationUsId())
                .build();
    }
}
