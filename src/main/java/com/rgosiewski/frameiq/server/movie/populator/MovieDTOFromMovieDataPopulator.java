/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.movie.populator;

import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.movie.data.MovieData;
import com.rgosiewski.frameiq.server.movie.dto.MovieDTO;

@Populator
public class MovieDTOFromMovieDataPopulator extends DataPopulator<MovieData, MovieDTO> {

    @Override
    public MovieDTO populate(MovieData movieData) {
        return MovieDTO.builder()
                .withBlueprintId(movieData.getBlueprintId())
                .withName(movieData.getName())
                .withDescription(movieData.getDescription())
                .withId(movieData.getId())
                .withCreationTime(movieData.getCreationTime())
                .withCreationUsId(movieData.getCreationUsId())
                .withModificationTime(movieData.getModificationTime())
                .withModificationUsId(movieData.getModificationUsId())
                .build();
    }
}
