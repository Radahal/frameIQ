/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.metadata.movieMetadata.controller;

import com.rgosiewski.frameiq.server.metadata.movieMetadata.dto.MovieMetadataDTO;
import com.rgosiewski.frameiq.server.metadata.movieMetadata.facade.MovieMetadataFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("movies/{movieId}/metadata/")
public class MovieMetadataController {
    private final Logger logger = LogManager.getLogger(MovieMetadataController.class);
    private final MovieMetadataFacade movieMetadataFacade;

    public MovieMetadataController(MovieMetadataFacade movieMetadataFacade) {
        this.movieMetadataFacade = movieMetadataFacade;
    }

    @GetMapping
    public List<MovieMetadataDTO> listAllMovieMetadata(@PathVariable Long movieId) {
        return movieMetadataFacade.listAllByMovieId(movieId);
    }

    @GetMapping("/{metadataId}")
    public MovieMetadataDTO getMovieMetadata(@PathVariable Long metadataId) {
        return movieMetadataFacade.getMovieMetadata(metadataId);
    }
}