/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.configuration.controller;

import com.rgosiewski.frameiq.server.configuration.dto.ConfigurationDTO;
import com.rgosiewski.frameiq.server.configuration.dto.CreateConfigurationDTO;
import com.rgosiewski.frameiq.server.configuration.dto.EditConfigurationDTO;
import com.rgosiewski.frameiq.server.configuration.facade.ConfigurationFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("projects/{projectId}/configurations/")
public class ConfigurationController {
    private final Logger logger = LogManager.getLogger(ConfigurationController.class);
    private final ConfigurationFacade configurationFacade;

    public ConfigurationController(ConfigurationFacade configurationFacade) {
        this.configurationFacade = configurationFacade;
    }

    @GetMapping
    public List<ConfigurationDTO> listConfigurations(@PathVariable Long projectId) {
        return configurationFacade.listConfigurations(projectId);
    }

    @GetMapping("/{configurationId}")
    public ConfigurationDTO getConfiguration(@PathVariable Long configurationId) {
        return configurationFacade.getConfiguration(configurationId);
    }

    @PutMapping
    public ConfigurationDTO createConfiguration(@PathVariable Long projectId,
                                      @RequestBody CreateConfigurationDTO createConfigurationDTO) {
        return configurationFacade.createConfiguration(projectId, createConfigurationDTO);
    }

    @PatchMapping("/{configurationId}")
    public ConfigurationDTO editConfiguration(@PathVariable Long configurationId,
                                    @RequestBody EditConfigurationDTO editConfigurationDTO) {
        return configurationFacade.editConfiguration(configurationId, editConfigurationDTO);
    }

}
