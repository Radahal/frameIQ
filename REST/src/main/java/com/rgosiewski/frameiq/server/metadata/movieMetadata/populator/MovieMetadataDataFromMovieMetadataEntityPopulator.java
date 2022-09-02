/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.metadata.movieMetadata.populator;

import com.rgosiewski.frameiq.database.implementation.model.MovieMetadataEntity;
import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.metadata.movieMetadata.data.MovieMetadataData;

@Populator
public class MovieMetadataDataFromMovieMetadataEntityPopulator extends DataPopulator<MovieMetadataEntity, MovieMetadataData> {

    @Override
    public MovieMetadataData populate(MovieMetadataEntity entity) {
        return MovieMetadataData.builder()
                .withMetadata(entity.getProcessedMetadata())
                .withExifMetadataId(entity.getExifMetadataId())
                .withId(entity.getId())
                .withCreationTime(entity.getCreationTime())
                .withCreationUsId(entity.getCreationUsId())
                .withModificationTime(entity.getModificationTime())
                .withModificationUsId(entity.getModificationUsId())
                .build();
    }
}
