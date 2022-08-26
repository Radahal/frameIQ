/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.configuration.populator;

import com.rgosiewski.frameiq.database.implementation.model.ConfigurationEntity;
import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.configuration.data.ConfigurationData;

@Populator
public class ConfigurationDataFromConfigurationEntityPopulator extends DataPopulator<ConfigurationEntity, ConfigurationData> {

    @Override
    public ConfigurationData populate(ConfigurationEntity iConfiguration) {
        return ConfigurationData.builder()
                .withId(iConfiguration.getId())
                .withProjectId(iConfiguration.getProjectId())
                .withName(iConfiguration.getName())
                .withInputFilename(iConfiguration.getInputFileName())
                .withDescription(iConfiguration.getDescription())
                .withTag(iConfiguration.getTag())
                .withAlgorithm(iConfiguration.getAlgorithm())
                .withAlgorithmProperties(iConfiguration.getAlgorithmProperties())
                .withStrategy(iConfiguration.getStrategy())
                .withCreationTime(iConfiguration.getCreationTime())
                .withCreationUsId(iConfiguration.getCreationUsId())
                .withModificationTime(iConfiguration.getModificationTime())
                .withModificationUsId(iConfiguration.getModificationUsId())
                .build();
    }
}
