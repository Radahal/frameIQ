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


    @Override
    public CreateConfigurationData populate(Long sourceId, CreateConfigurationDTO createConfigurationDTO) {
        return CreateConfigurationData.builder()
                .withProjectId(sourceId)
                .withName(createConfigurationDTO.getName())
                .withDescription(createConfigurationDTO.getDescription())
                .withTag(createConfigurationDTO.getTag())
                .withInputFilename(createConfigurationDTO.getInputFilename())
                .withAlgorithm(createConfigurationDTO.getAlgorithm())
                .withAlgorithmProperties(createConfigurationDTO.getAlgorithmProperties())
                .withStrategy(createConfigurationDTO.getStrategy())
                .build();
    }
}
