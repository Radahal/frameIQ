/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.metadata.movieMetadata.facade;

import com.rgosiewski.frameiq.database.implementation.service.MovieMetadataService;
import com.rgosiewski.frameiq.server.common.stereotype.Facade;
import com.rgosiewski.frameiq.server.metadata.movieMetadata.dto.MovieMetadataDTO;
import com.rgosiewski.frameiq.server.metadata.movieMetadata.populator.MovieMetadataDTOFromMovieMetadataDataPopulator;

import java.util.List;

@Facade
public class MovieMetadataFacade {
    private final MovieMetadataService movieMetadataService;
    private final MovieMetadataDTOFromMovieMetadataDataPopulator fromMovieMetadataDataPopulator;

    public MovieMetadataFacade(MovieMetadataService movieMetadataService,
                               MovieMetadataDTOFromMovieMetadataDataPopulator fromMovieMetadataDataPopulator) {
        this.movieMetadataService = movieMetadataService;
        this.fromMovieMetadataDataPopulator = fromMovieMetadataDataPopulator;
    }

    public MovieMetadataDTO getMovieMetadata(Long movieMetadataId) {
        return fromMovieMetadataDataPopulator.populate(movieMetadataService.getMovieMetadata(movieMetadataId));
    }

    public List<MovieMetadataDTO> listAllByMovieId(Long movieId) {
        return fromMovieMetadataDataPopulator.populateAll(movieMetadataService.listMovieMetadata(movieId));
    }

}
