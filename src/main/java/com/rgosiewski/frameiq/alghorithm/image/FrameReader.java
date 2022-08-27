/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.alghorithm.image;

import com.rgosiewski.frameiq.database.implementation.service.*;
import com.rgosiewski.frameiq.server.configuration.data.AlgorithmPropertiesData;
import com.rgosiewski.frameiq.server.configuration.data.ConfigurationData;
import com.rgosiewski.frameiq.server.movie.data.MovieData;
import com.rgosiewski.frameiq.server.project.data.ProjectData;
import com.rgosiewski.frameiq.workspace.management.Workspace;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class FrameReader {
    private static final Logger logger = LogManager.getLogger(FrameReader.class);
    private final FrameService frameService;
    private final FrameMetadataService frameMetadataService;
    private final ExifMetadataService exifMetadataService;
    private final MovieService movieService;
    private final ImageExifReader imageExifReader;
    private final Workspace workspace;
    private final ProjectService projectService;

    public FrameReader(FrameService frameService,
                       FrameMetadataService frameMetadataService,
                       ExifMetadataService exifMetadataService,
                       MovieService movieService,
                       ImageExifReader imageExifReader,
                       Workspace workspace,
                       ProjectService projectService) {
        this.frameService = frameService;
        this.frameMetadataService = frameMetadataService;
        this.exifMetadataService = exifMetadataService;
        this.movieService = movieService;
        this.imageExifReader = imageExifReader;
        this.workspace = workspace;
        this.projectService = projectService;
    }

    public void processNewFrames(Long processingId, MovieData movieData, ConfigurationData configurationData) {
        ProjectData project = projectService.getProject(configurationData.getProjectId());
        List<File> files = workspace.listProjectFilesByFileExtension(project.getName(), configurationData.getAlgorithmProperties().getFileExtension());
        processFrames(files, movieData.getId(), processingId, configurationData.getAlgorithmProperties());
    }

    public void processExistingFrames(Long processingId, ConfigurationData configurationData) {
        String movieName = configurationData.getAlgorithmProperties().getVideoPath().getFileName().toString();
        MovieData movieData = movieService.findByName(movieName);

        ProjectData project = projectService.getProject(configurationData.getProjectId());
        List<File> files = workspace.listProjectFilesByFileExtension(project.getName(), configurationData.getAlgorithmProperties().getFileExtension());
        processFrames(files, movieData.getId(), processingId, configurationData.getAlgorithmProperties());
    }

    private void processFrames(List<File> files, Long movieId, Long processingId, AlgorithmPropertiesData algorithmProperties) {
        for (File file : files) {
            ImageProcessor imageProcessor = new ImageProcessor(frameService, frameMetadataService, exifMetadataService, imageExifReader, movieId, processingId, file, algorithmProperties);
            imageProcessor.run();
        }
        logger.log(Level.INFO, "All frames has been processed");
    }

}
