/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.frame.populator;

import com.rgosiewski.frameiq.server.common.populator.ByIdDataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.frame.data.EditFrameData;
import com.rgosiewski.frameiq.server.frame.dto.EditFrameDTO;

@Populator
public class EditFrameDataFromEditFrameDTOPopulator extends ByIdDataPopulator<EditFrameDTO, EditFrameData> {

    @Override
    public EditFrameData populate(Long sourceId, EditFrameDTO editMovieDTO) {
        return EditFrameData.builder()
                .withFrameId(sourceId)
                .withName(editMovieDTO.getName())
                .withDescription(editMovieDTO.getDescription())
                .build();
    }
}
