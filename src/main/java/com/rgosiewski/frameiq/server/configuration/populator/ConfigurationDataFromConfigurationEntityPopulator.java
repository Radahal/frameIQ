/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.configuration.populator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rgosiewski.frameiq.database.implementation.model.ConfigurationEntity;
import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.common.utils.PathConverter;
import com.rgosiewski.frameiq.server.configuration.data.AlgorithmPropertiesData;
import com.rgosiewski.frameiq.server.configuration.data.ConfigurationData;

import java.nio.file.Path;

@Populator
public class ConfigurationDataFromConfigurationEntityPopulator extends DataPopulator<ConfigurationEntity, ConfigurationData> {

    @Override
    public ConfigurationData populate(ConfigurationEntity iConfiguration) {
        return ConfigurationData.builder()
                .withId(iConfiguration.getId())
                .withProjectId(iConfiguration.getProjectId())
                .withName(iConfiguration.getName())
                .withDescription(iConfiguration.getDescription())
                .withTag(iConfiguration.getTag())
                .withAlgorithmProperties(deserializeAlgorithmProperties(iConfiguration.getAlgorithmProperties()))
                .withCreationTime(iConfiguration.getCreationTime())
                .withCreationUsId(iConfiguration.getCreationUsId())
                .withModificationTime(iConfiguration.getModificationTime())
                .withModificationUsId(iConfiguration.getModificationUsId())
                .build();
    }

    private AlgorithmPropertiesData deserializeAlgorithmProperties(String algorithmProperties) {
        Gson gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(Path.class, new PathConverter())
                .create();
        return gson.fromJson(algorithmProperties, AlgorithmPropertiesData.class);
    }
}
