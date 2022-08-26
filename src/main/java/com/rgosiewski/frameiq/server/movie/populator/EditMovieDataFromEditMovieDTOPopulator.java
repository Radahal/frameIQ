/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.movie.populator;

import com.rgosiewski.frameiq.server.common.populator.ByIdDataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.movie.data.EditMovieData;
import com.rgosiewski.frameiq.server.movie.dto.EditMovieDTO;

@Populator
public class EditMovieDataFromEditMovieDTOPopulator extends ByIdDataPopulator<EditMovieDTO, EditMovieData> {

    @Override
    public EditMovieData populate(Long sourceId, EditMovieDTO editMovieDTO) {
        return EditMovieData.builder()
                .withMovieId(sourceId)
                .withName(editMovieDTO.getName())
                .withDescription(editMovieDTO.getDescription())
                .build();
    }
}
