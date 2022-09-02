/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.blueprint.populator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rgosiewski.frameiq.database.implementation.model.BlueprintEntity;
import com.rgosiewski.frameiq.server.blueprint.data.BlueprintData;
import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.common.utils.PathConverter;
import com.rgosiewski.frameiq.server.configuration.data.AlgorithmPropertiesData;

import java.nio.file.Path;

@Populator
public class BlueprintDataFromBlueprintEntityPopulator extends DataPopulator<BlueprintEntity, BlueprintData> {

    @Override
    public BlueprintData populate(BlueprintEntity iBlueprint) {
        return BlueprintData.builder()
                .withConfigurationId(iBlueprint.getConfigurationId())
                .withName(iBlueprint.getName())
                .withTag(iBlueprint.getTag())
                .withAlgorithmProperties(deserializeAlgorithmProperties(iBlueprint.getAlgorithmProperties()))
                .withId(iBlueprint.getId())
                .withCreationTime(iBlueprint.getCreationTime())
                .withCreationUsId(iBlueprint.getCreationUsId())
                .withModificationTime(iBlueprint.getModificationTime())
                .withModificationUsId(iBlueprint.getModificationUsId())
                .build();
    }

    private AlgorithmPropertiesData deserializeAlgorithmProperties(String algorithmProperties) {
        Gson gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(Path.class, new PathConverter())
                .create();
        return gson.fromJson(algorithmProperties, AlgorithmPropertiesData.class);
    }
}
