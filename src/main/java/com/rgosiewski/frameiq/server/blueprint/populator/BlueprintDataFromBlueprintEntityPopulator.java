/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.blueprint.populator;

import com.rgosiewski.frameiq.database.implementation.model.BlueprintEntity;
import com.rgosiewski.frameiq.server.blueprint.data.BlueprintData;
import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;

@Populator
public class BlueprintDataFromBlueprintEntityPopulator extends DataPopulator<BlueprintEntity, BlueprintData> {

    @Override
    public BlueprintData populate(BlueprintEntity iBlueprint) {
        return BlueprintData.builder()
                .withConfigurationId(iBlueprint.getConfigurationId())
                .withName(iBlueprint.getName())
                .withTag(iBlueprint.getTag())
                .withAlgorithm(iBlueprint.getAlgorithm())
                .withAlgorithmProperties(iBlueprint.getAlgorithmProperties())
                .withStrategy(iBlueprint.getStrategy())
                .withId(iBlueprint.getId())
                .withCreationTime(iBlueprint.getCreationTime())
                .withCreationUsId(iBlueprint.getCreationUsId())
                .withModificationTime(iBlueprint.getModificationTime())
                .withModificationUsId(iBlueprint.getModificationUsId())
                .build();
    }
}
