/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.blueprint.populator;

import com.rgosiewski.frameiq.server.blueprint.data.CreateBlueprintData;
import com.rgosiewski.frameiq.server.blueprint.dto.CreateBlueprintDTO;
import com.rgosiewski.frameiq.server.common.populator.ByIdDataPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Populator;

@Populator
public class CreateBlueprintDataFromCreateBlueprintDTOPopulator extends ByIdDataPopulator<CreateBlueprintDTO, CreateBlueprintData> {


    @Override
    public CreateBlueprintData populate(Long sourceId, CreateBlueprintDTO createBlueprintDTO) {
        return CreateBlueprintData.builder()
                .withProjectId(sourceId)
                .withConfigurationId(createBlueprintDTO.getConfigurationId())
                .build();
    }
}
