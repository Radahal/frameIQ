/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.movie.facade;

import com.rgosiewski.frameiq.database.implementation.service.MovieService;
import com.rgosiewski.frameiq.server.common.stereotype.Facade;
import com.rgosiewski.frameiq.server.movie.dto.EditMovieDTO;
import com.rgosiewski.frameiq.server.movie.dto.MovieDTO;
import com.rgosiewski.frameiq.server.movie.populator.EditMovieDataFromEditMovieDTOPopulator;
import com.rgosiewski.frameiq.server.movie.populator.MovieDTOFromMovieDataPopulator;

import java.util.List;

@Facade
public class MovieFacade {
    private final MovieService movieService;
    private final MovieDTOFromMovieDataPopulator fromMovieDataPopulator;
    private final EditMovieDataFromEditMovieDTOPopulator fromEditMovieDTOPopulator;

    public MovieFacade(MovieService movieService,
                       MovieDTOFromMovieDataPopulator fromMovieDataPopulator,
                       EditMovieDataFromEditMovieDTOPopulator fromEditMovieDTOPopulator) {
        this.movieService = movieService;
        this.fromMovieDataPopulator = fromMovieDataPopulator;
        this.fromEditMovieDTOPopulator = fromEditMovieDTOPopulator;
    }

    public MovieDTO getMovie(Long movieId) {
        return fromMovieDataPopulator.populate(movieService.getMovie(movieId));
    }

    public List<MovieDTO> listAllByBlueprintId(Long blueprintId) {
        return fromMovieDataPopulator.populateAll(movieService.listAllByBlueprintId(blueprintId));
    }

    public MovieDTO editMovie(Long movieId, EditMovieDTO editMovieDTO) {
        return fromMovieDataPopulator.populate(
                movieService.editMovie(fromEditMovieDTOPopulator.populate(movieId, editMovieDTO))
        );
    }
}
