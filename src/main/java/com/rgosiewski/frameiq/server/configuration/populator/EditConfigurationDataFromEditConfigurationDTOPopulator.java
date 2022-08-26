/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.configuration.populator;

import com.rgosiewski.frameiq.server.common.populator.ByIdDataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.configuration.data.EditConfigurationData;
import com.rgosiewski.frameiq.server.configuration.dto.EditConfigurationDTO;

@Populator
public class EditConfigurationDataFromEditConfigurationDTOPopulator extends ByIdDataPopulator<EditConfigurationDTO, EditConfigurationData> {


    @Override
    public EditConfigurationData populate(Long sourceId, EditConfigurationDTO editConfigurationDTO) {
        return EditConfigurationData.builder()
                .withId(sourceId)
                .withName(editConfigurationDTO.getName())
                .withDescription(editConfigurationDTO.getDescription())
                .withTag(editConfigurationDTO.getTag())
                .withInputFilename(editConfigurationDTO.getInputFilename())
                .withAlgorithm(editConfigurationDTO.getAlgorithm())
                .withAlgorithmProperties(editConfigurationDTO.getAlgorithmProperties())
                .withStrategy(editConfigurationDTO.getStrategy())
                .build();
    }
}
