/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.configuration.populator;

import com.rgosiewski.frameiq.server.common.populator.ByIdDataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.configuration.data.CreateConfigurationData;
import com.rgosiewski.frameiq.server.configuration.dto.CreateConfigurationDTO;

@Populator
public class CreateConfigurationDataFromCreateConfigurationDTOPopulator extends ByIdDataPopulator<CreateConfigurationDTO, CreateConfigurationData> {
    private final AlgorithmPropertiesDataFromAlgorithmPropertiesDTOPopulator fromAlgorithmPropertiesDTOPopulator;

    public CreateConfigurationDataFromCreateConfigurationDTOPopulator(AlgorithmPropertiesDataFromAlgorithmPropertiesDTOPopulator fromAlgorithmPropertiesDTOPopulator) {
        this.fromAlgorithmPropertiesDTOPopulator = fromAlgorithmPropertiesDTOPopulator;
    }

    @Override
    public CreateConfigurationData populate(Long sourceId, CreateConfigurationDTO createConfigurationDTO) {
        return CreateConfigurationData.builder()
                .withProjectId(sourceId)
                .withName(createConfigurationDTO.getName())
                .withDescription(createConfigurationDTO.getDescription())
                .withTag(createConfigurationDTO.getTag())
                .withAlgorithmProperties(fromAlgorithmPropertiesDTOPopulator.populate(createConfigurationDTO.getAlgorithmProperties()))
                .build();
    }
}
