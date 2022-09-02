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
    private final AlgorithmPropertiesDTOFromAlgorithmPropertiesDataPopulator fromAlgorithmPropertiesDataPopulator;

    public ConfigurationDTOFromConfigurationDataPopulator(AlgorithmPropertiesDTOFromAlgorithmPropertiesDataPopulator fromAlgorithmPropertiesDataPopulator) {
        this.fromAlgorithmPropertiesDataPopulator = fromAlgorithmPropertiesDataPopulator;
    }

    @Override
    public ConfigurationDTO populate(ConfigurationData configurationData) {
        return ConfigurationDTO.builder()
                .withId(configurationData.getId())
                .withProjectId(configurationData.getProjectId())
                .withName(configurationData.getName())
                .withDescription(configurationData.getDescription())
                .withTag(configurationData.getTag())
                .withAlgorithmProperties(fromAlgorithmPropertiesDataPopulator.populate(configurationData.getAlgorithmProperties()))
                .withId(configurationData.getId())
                .withCreationTime(configurationData.getCreationTime())
                .withCreationUsId(configurationData.getCreationUsId())
                .withModificationTime(configurationData.getModificationTime())
                .withModificationUsId(configurationData.getModificationUsId())
                .build();
    }
}
