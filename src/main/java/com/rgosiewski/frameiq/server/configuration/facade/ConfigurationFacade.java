/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.configuration.facade;

import com.rgosiewski.frameiq.database.implementation.service.ConfigurationService;
import com.rgosiewski.frameiq.server.common.stereotype.Facade;
import com.rgosiewski.frameiq.server.configuration.dto.ConfigurationDTO;
import com.rgosiewski.frameiq.server.configuration.dto.CreateConfigurationDTO;
import com.rgosiewski.frameiq.server.configuration.dto.EditConfigurationDTO;
import com.rgosiewski.frameiq.server.configuration.populator.ConfigurationDTOFromConfigurationDataPopulator;
import com.rgosiewski.frameiq.server.configuration.populator.CreateConfigurationDataFromCreateConfigurationDTOPopulator;
import com.rgosiewski.frameiq.server.configuration.populator.EditConfigurationDataFromEditConfigurationDTOPopulator;

import java.util.List;

@Facade
public class ConfigurationFacade {
    private final ConfigurationService configurationService;
    private final ConfigurationDTOFromConfigurationDataPopulator fromConfigurationDataPopulator;
    private final CreateConfigurationDataFromCreateConfigurationDTOPopulator fromCreateConfigurationDTOPopulator;
    private final EditConfigurationDataFromEditConfigurationDTOPopulator fromEditConfigurationDTOPopulator;

    public ConfigurationFacade(ConfigurationService configurationService,
                               ConfigurationDTOFromConfigurationDataPopulator fromConfigurationDataPopulator,
                               CreateConfigurationDataFromCreateConfigurationDTOPopulator fromCreateConfigurationDTOPopulator,
                               EditConfigurationDataFromEditConfigurationDTOPopulator fromEditConfigurationDTOPopulator) {
        this.configurationService = configurationService;
        this.fromConfigurationDataPopulator = fromConfigurationDataPopulator;
        this.fromCreateConfigurationDTOPopulator = fromCreateConfigurationDTOPopulator;
        this.fromEditConfigurationDTOPopulator = fromEditConfigurationDTOPopulator;
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
}
