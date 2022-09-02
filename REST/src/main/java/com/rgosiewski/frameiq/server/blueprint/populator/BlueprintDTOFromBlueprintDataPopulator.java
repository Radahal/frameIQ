/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.blueprint.populator;

import com.rgosiewski.frameiq.server.blueprint.data.BlueprintData;
import com.rgosiewski.frameiq.server.blueprint.dto.BlueprintDTO;
import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.configuration.populator.AlgorithmPropertiesDTOFromAlgorithmPropertiesDataPopulator;

@Populator
public class BlueprintDTOFromBlueprintDataPopulator extends DataPopulator<BlueprintData, BlueprintDTO> {
    private final AlgorithmPropertiesDTOFromAlgorithmPropertiesDataPopulator fromAlgorithmPropertiesDataPopulator;

    public BlueprintDTOFromBlueprintDataPopulator(AlgorithmPropertiesDTOFromAlgorithmPropertiesDataPopulator fromAlgorithmPropertiesDataPopulator) {
        this.fromAlgorithmPropertiesDataPopulator = fromAlgorithmPropertiesDataPopulator;
    }

    @Override
    public BlueprintDTO populate(BlueprintData blueprintData) {
        return BlueprintDTO.builder()
                .withConfigurationId(blueprintData.getConfigurationId())
                .withName(blueprintData.getName())
                .withTag(blueprintData.getTag())
                .withAlgorithmProperties(fromAlgorithmPropertiesDataPopulator.populate(blueprintData.getAlgorithmProperties()))
                .withId(blueprintData.getId())
                .withCreationTime(blueprintData.getCreationTime())
                .withCreationUsId(blueprintData.getCreationUsId())
                .withModificationTime(blueprintData.getModificationTime())
                .withModificationUsId(blueprintData.getModificationUsId())
                .build();
    }
}
