/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.metadata.movieMetadata.populator;

import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.metadata.movieMetadata.data.MovieMetadataData;
import com.rgosiewski.frameiq.server.metadata.movieMetadata.dto.MovieMetadataDTO;

@Populator
public class MovieMetadataDTOFromMovieMetadataDataPopulator extends DataPopulator<MovieMetadataData, MovieMetadataDTO> {

    @Override
    public MovieMetadataDTO populate(MovieMetadataData movieMetadataData) {
        return MovieMetadataDTO.builder()
                .withMetadata(movieMetadataData.getMetadata())
                .withExifMetadataId(movieMetadataData.getExifMetadataId())
                .withId(movieMetadataData.getId())
                .withCreationTime(movieMetadataData.getCreationTime())
                .withCreationUsId(movieMetadataData.getCreationUsId())
                .withModificationTime(movieMetadataData.getModificationTime())
                .withModificationUsId(movieMetadataData.getModificationUsId())
                .build();
    }
}
