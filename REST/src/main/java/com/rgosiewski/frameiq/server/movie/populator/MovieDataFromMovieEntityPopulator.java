/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.movie.populator;

import com.rgosiewski.frameiq.database.implementation.model.MovieEntity;
import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.movie.data.MovieData;

@Populator
public class MovieDataFromMovieEntityPopulator extends DataPopulator<MovieEntity, MovieData> {

    @Override
    public MovieData populate(MovieEntity entity) {
        return MovieData.builder()
                .withBlueprintId(entity.getBlueprintId())
                .withName(entity.getName())
                .withDescription(entity.getDescription())
                .withId(entity.getId())
                .withCreationTime(entity.getCreationTime())
                .withCreationUsId(entity.getCreationUsId())
                .withModificationTime(entity.getModificationTime())
                .withModificationUsId(entity.getModificationUsId())
                .build();
    }
}
