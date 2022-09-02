/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.alghorithm.video;

import com.rgosiewski.frameiq.database.implementation.service.MovieService;
import com.rgosiewski.frameiq.database.implementation.service.ProjectService;
import com.rgosiewski.frameiq.server.blueprint.data.BlueprintData;
import com.rgosiewski.frameiq.server.configuration.data.ConfigurationData;
import com.rgosiewski.frameiq.server.movie.data.CreateMovieData;
import com.rgosiewski.frameiq.server.movie.data.MovieData;
import com.rgosiewski.frameiq.server.processing.data.ProcessingData;
import com.rgosiewski.frameiq.server.project.data.ProjectData;
import com.rgosiewski.frameiq.workspace.management.Workspace;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public class VideoSplitter {
    private static final Logger logger = LogManager.getLogger(VideoSplitter.class);
    private final ProjectService projectService;
    private final MovieService movieService;
    private final Workspace workspace;

    public VideoSplitter(ProjectService projectService,
                         MovieService movieService,
                         Workspace workspace) {
        this.projectService = projectService;
        this.movieService = movieService;
        this.workspace = workspace;
    }

    public MovieData processVideo(BlueprintData blueprintData, ProcessingData processingData, ConfigurationData configuration) {
        ProjectData project = projectService.getProject(configuration.getProjectId());
        Path projectPath = workspace.getOrCreateProjectPath(project.getName());
        Path configurationPath = workspace.getOrCreateConfigurationPath(projectPath, configuration.getName());
        Path processingPath = workspace.getOrCreateProcessingPath(configurationPath, processingData.getId());
        VideoProcessor videoProcessor = new VideoProcessor(configuration.getAlgorithmProperties(), processingPath);
        videoProcessor.run();
        logger.log(Level.INFO, "Video has been processed (frames has been extracted).");
        return movieService.createMovie(CreateMovieData.builder()
                .withBlueprintId(blueprintData.getConfigurationId())
                .withName(configuration.getAlgorithmProperties().getVideoPath().getFileName().toString())
                .withDescription(project.getName() + " - " + configuration.getAlgorithmProperties().getVideoPath().getFileName().toString())
                .build());
    }
}
