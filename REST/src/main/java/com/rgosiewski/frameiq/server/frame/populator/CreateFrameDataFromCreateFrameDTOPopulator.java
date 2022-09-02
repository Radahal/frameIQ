/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.frame.populator;

import com.rgosiewski.frameiq.server.common.populator.ByIdDataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.frame.data.CreateFrameData;
import com.rgosiewski.frameiq.server.frame.dto.CreateFrameDTO;

@Populator
public class CreateFrameDataFromCreateFrameDTOPopulator extends ByIdDataPopulator<CreateFrameDTO, CreateFrameData> {

    @Override
    public CreateFrameData populate(Long sourceId, CreateFrameDTO createFrameDTO) {
        return CreateFrameData.builder()
                .withMovieId(sourceId)
                .withName(createFrameDTO.getName())
                .withDescription(createFrameDTO.getDescription())
                .withOrdinal(createFrameDTO.getOrdinal())
                .build();
    }
}
