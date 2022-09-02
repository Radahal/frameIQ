/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.configuration.populator;

import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.configuration.data.AlgorithmPropertiesData;
import com.rgosiewski.frameiq.server.configuration.dto.AlgorithmPropertiesDTO;

@Populator
public class AlgorithmPropertiesDTOFromAlgorithmPropertiesDataPopulator extends DataPopulator<AlgorithmPropertiesData, AlgorithmPropertiesDTO> {

    @Override
    public AlgorithmPropertiesDTO populate(AlgorithmPropertiesData algorithmPropertiesData) {
        return AlgorithmPropertiesDTO.builder()
                .withStrategy(algorithmPropertiesData.getStrategy())
                .withVideoPath(algorithmPropertiesData.getVideoPath().toString())
                .withFileExtension(algorithmPropertiesData.getFileExtension())
                .withMetric(algorithmPropertiesData.getMetric())
                .withTreshold(algorithmPropertiesData.getTreshold())
                .withRemoveBlurred(algorithmPropertiesData.isRemoveBlurred())
                .build();
    }
}
