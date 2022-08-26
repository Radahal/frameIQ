/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.blueprint.populator;

import com.rgosiewski.frameiq.server.blueprint.data.BlueprintData;
import com.rgosiewski.frameiq.server.blueprint.dto.BlueprintDTO;
import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;

@Populator
public class BlueprintDTOFromBlueprintDataPopulator extends DataPopulator<BlueprintData, BlueprintDTO> {

    @Override
    public BlueprintDTO populate(BlueprintData blueprintData) {
        return BlueprintDTO.builder()
                .withConfigurationId(blueprintData.getConfigurationId())
                .withName(blueprintData.getName())
                .withTag(blueprintData.getTag())
                .withAlgorithm(blueprintData.getAlgorithm())
                .withAlgorithmProperties(blueprintData.getAlgorithmProperties())
                .withStrategy(blueprintData.getStrategy())
                .withId(blueprintData.getId())
                .withCreationTime(blueprintData.getCreationTime())
                .withCreationUsId(blueprintData.getCreationUsId())
                .withModificationTime(blueprintData.getModificationTime())
                .withModificationUsId(blueprintData.getModificationUsId())
                .build();
    }
}
