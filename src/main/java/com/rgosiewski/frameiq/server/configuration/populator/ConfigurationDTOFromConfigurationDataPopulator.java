/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.configuration.populator;

import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.configuration.data.ConfigurationData;
import com.rgosiewski.frameiq.server.configuration.dto.ConfigurationDTO;

@Populator
public class ConfigurationDTOFromConfigurationDataPopulator extends DataPopulator<ConfigurationData, ConfigurationDTO> {

    @Override
    public ConfigurationDTO populate(ConfigurationData configurationData) {
        return ConfigurationDTO.builder()
                .withId(configurationData.getId())
                .withProjectId(configurationData.getProjectId())
                .withName(configurationData.getName())
                .withDescription(configurationData.getDescription())
                .withInputFilename(configurationData.getInputFilename())
                .withTag(configurationData.getTag())
                .withAlgorithm(configurationData.getAlgorithm())
                .withAlgorithmProperties(configurationData.getAlgorithmProperties())
                .withStrategy(configurationData.getStrategy())
                .withId(configurationData.getId())
                .withCreationTime(configurationData.getCreationTime())
                .withCreationUsId(configurationData.getCreationUsId())
                .withModificationTime(configurationData.getModificationTime())
                .withModificationUsId(configurationData.getModificationUsId())
                .build();
    }
}
