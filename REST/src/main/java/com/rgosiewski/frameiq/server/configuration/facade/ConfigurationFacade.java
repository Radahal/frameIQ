/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.configuration.facade;

import com.rgosiewski.frameiq.alghorithm.image.FrameReader;
import com.rgosiewski.frameiq.alghorithm.video.VideoSplitter;
import com.rgosiewski.frameiq.database.implementation.service.BlueprintService;
import com.rgosiewski.frameiq.database.implementation.service.ConfigurationService;
import com.rgosiewski.frameiq.database.implementation.service.ProcessingService;
import com.rgosiewski.frameiq.server.blueprint.data.BlueprintData;
import com.rgosiewski.frameiq.server.blueprint.data.CreateBlueprintData;
import com.rgosiewski.frameiq.server.common.stereotype.Facade;
import com.rgosiewski.frameiq.server.configuration.data.ConfigurationData;
import com.rgosiewski.frameiq.server.configuration.dto.ConfigurationDTO;
import com.rgosiewski.frameiq.server.configuration.dto.CreateConfigurationDTO;
import com.rgosiewski.frameiq.server.configuration.dto.EditConfigurationDTO;
import com.rgosiewski.frameiq.server.configuration.enums.Strategy;
import com.rgosiewski.frameiq.server.configuration.populator.ConfigurationDTOFromConfigurationDataPopulator;
import com.rgosiewski.frameiq.server.configuration.populator.CreateConfigurationDataFromCreateConfigurationDTOPopulator;
import com.rgosiewski.frameiq.server.configuration.populator.EditConfigurationDataFromEditConfigurationDTOPopulator;
import com.rgosiewski.frameiq.server.movie.data.MovieData;
import com.rgosiewski.frameiq.server.processing.data.ProcessingData;
import com.rgosiewski.frameiq.server.processing.exception.ProcessingException;

import java.util.List;

@Facade
public class ConfigurationFacade {
    private final ConfigurationService configurationService;
    private final BlueprintService blueprintService;
    private final ProcessingService processingService;
    private final ConfigurationDTOFromConfigurationDataPopulator fromConfigurationDataPopulator;
    private final CreateConfigurationDataFromCreateConfigurationDTOPopulator fromCreateConfigurationDTOPopulator;
    private final EditConfigurationDataFromEditConfigurationDTOPopulator fromEditConfigurationDTOPopulator;
    private final VideoSplitter videoSplitter;
    private final FrameReader frameReader;

    public ConfigurationFacade(ConfigurationService configurationService,
                               BlueprintService blueprintService,
                               ProcessingService processingService,
                               ConfigurationDTOFromConfigurationDataPopulator fromConfigurationDataPopulator,
                               CreateConfigurationDataFromCreateConfigurationDTOPopulator fromCreateConfigurationDTOPopulator,
                               EditConfigurationDataFromEditConfigurationDTOPopulator fromEditConfigurationDTOPopulator,
                               VideoSplitter videoSplitter,
                               FrameReader frameReader) {
        this.configurationService = configurationService;
        this.blueprintService = blueprintService;
        this.processingService = processingService;
        this.fromConfigurationDataPopulator = fromConfigurationDataPopulator;
        this.fromCreateConfigurationDTOPopulator = fromCreateConfigurationDTOPopulator;
        this.fromEditConfigurationDTOPopulator = fromEditConfigurationDTOPopulator;
        this.videoSplitter = videoSplitter;
        this.frameReader = frameReader;
    }

    public ConfigurationDTO getConfiguration(Long configurationId) {
        return fromConfigurationDataPopulator.populate(configurationService.getConfiguration(configurationId));
    }

    public List<ConfigurationDTO> listConfigurations(Long projectId) {
        return fromConfigurationDataPopulator.populateAll(configurationService.listConfigurations(projectId));
    }

    public ConfigurationDTO createConfiguration(Long projectId, CreateConfigurationDTO createConfigurationDTO) {
       return fromConfigurationDataPopulator.populate(
               configurationService.createConfiguration(fromCreateConfigurationDTOPopulator.populate(projectId, createConfigurationDTO))
       );
    }

    public ConfigurationDTO editConfiguration(Long projectId, EditConfigurationDTO editConfigurationDTO) {
        return fromConfigurationDataPopulator.populate(
                configurationService.editConfiguration(fromEditConfigurationDTOPopulator.populate(projectId, editConfigurationDTO))
        );
    }

    public void runConfiguration(Long configurationId) {
        ConfigurationData configuration = configurationService.getConfiguration(configurationId);
        BlueprintData blueprint = blueprintService.createBlueprint(CreateBlueprintData.builder()
                .withConfigurationId(configurationId)
                .build());

        ProcessingData processingData = processingService.startProcessing(blueprint.getId());
        try {
            Strategy strategy = configuration.getAlgorithmProperties().getStrategy();
            switch (strategy) {
                case SPLIT_VIDEO:
                    MovieData movieData = videoSplitter.processVideo(blueprint, processingData, configuration);
                    frameReader.processNewFrames(processingData.getId(), movieData, configuration);
                    break;
                case PROCESS_FRAMES:
                    frameReader.processExistingFrames(processingData.getId(), configuration);
            }
            processingService.finishProcessing(processingData.getId(), blueprint.getId());
        } catch (RuntimeException e) {
            processingService.abortProcessing(processingData.getId(), blueprint.getId());
            throw new ProcessingException(processingData, e);
        }
    }
}
