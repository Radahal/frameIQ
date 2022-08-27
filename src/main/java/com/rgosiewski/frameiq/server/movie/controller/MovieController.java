/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.movie.controller;

import com.rgosiewski.frameiq.server.movie.dto.EditMovieDTO;
import com.rgosiewski.frameiq.server.movie.dto.MovieDTO;
import com.rgosiewski.frameiq.server.movie.facade.MovieFacade;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies/")
public class MovieController {
    private final MovieFacade movieFacade;

    public MovieController(MovieFacade movieFacade) {
        this.movieFacade = movieFacade;
    }

    @GetMapping("/{movieId}")
    public MovieDTO getMovie(@PathVariable Long movieId) {
        return movieFacade.getMovie(movieId);
    }

    @PatchMapping("/{movieId}")
    public MovieDTO editMovie(@PathVariable Long movieId,
                              @RequestBody @Validated EditMovieDTO editMovieDTO) {
        return movieFacade.editMovie(movieId, editMovieDTO);
    }

    @GetMapping("/blueprints/{blueprintId}")
    public List<MovieDTO> listMovieByBlueprintId(@PathVariable Long blueprintId) {
        return movieFacade.listAllByBlueprintId(blueprintId);
    }

}
