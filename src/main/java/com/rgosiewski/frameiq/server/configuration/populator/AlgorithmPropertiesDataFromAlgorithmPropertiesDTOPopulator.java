/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.configuration.populator;

import com.rgosiewski.frameiq.server.common.populator.DataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;
import com.rgosiewski.frameiq.server.configuration.data.AlgorithmPropertiesData;
import com.rgosiewski.frameiq.server.configuration.dto.AlgorithmPropertiesDTO;

import java.nio.file.Paths;

@Populator
public class AlgorithmPropertiesDataFromAlgorithmPropertiesDTOPopulator extends DataPopulator<AlgorithmPropertiesDTO, AlgorithmPropertiesData> {

    @Override
    public AlgorithmPropertiesData populate(AlgorithmPropertiesDTO algorithmPropertiesDTO) {
        return AlgorithmPropertiesData.builder()
                .withStrategy(algorithmPropertiesDTO.getStrategy())
                .withVideoPath(Paths.get(algorithmPropertiesDTO.getVideoPath()))
                .withFileExtension(algorithmPropertiesDTO.getFileExtension())
                .withMetric(algorithmPropertiesDTO.getMetric())
                .withTreshold(algorithmPropertiesDTO.getTreshold())
                .withRemoveBlurred(algorithmPropertiesDTO.isRemoveBlurred())
                .build();
    }
}
