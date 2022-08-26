/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.blueprint.facade;

import com.rgosiewski.frameiq.database.implementation.service.BlueprintService;
import com.rgosiewski.frameiq.server.blueprint.dto.BlueprintDTO;
import com.rgosiewski.frameiq.server.blueprint.dto.CreateBlueprintDTO;
import com.rgosiewski.frameiq.server.blueprint.populator.BlueprintDTOFromBlueprintDataPopulator;
import com.rgosiewski.frameiq.server.blueprint.populator.CreateBlueprintDataFromCreateBlueprintDTOPopulator;
import com.rgosiewski.frameiq.server.common.stereotype.Facade;

import java.util.List;

@Facade
public class BlueprintFacade {
    private final BlueprintService blueprintService;
    private final BlueprintDTOFromBlueprintDataPopulator fromBlueprintDataPopulator;
    private final CreateBlueprintDataFromCreateBlueprintDTOPopulator fromCreateBlueprintDTOPopulator;

    public BlueprintFacade(BlueprintService blueprintService,
                           BlueprintDTOFromBlueprintDataPopulator fromBlueprintDataPopulator,
                           CreateBlueprintDataFromCreateBlueprintDTOPopulator fromCreateBlueprintDTOPopulator) {
        this.blueprintService = blueprintService;
        this.fromBlueprintDataPopulator = fromBlueprintDataPopulator;
        this.fromCreateBlueprintDTOPopulator = fromCreateBlueprintDTOPopulator;
    }

    public BlueprintDTO getBlueprint(Long blueprintId) {
        return fromBlueprintDataPopulator.populate(blueprintService.getBlueprint(blueprintId));
    }

    public List<BlueprintDTO> listBlueprints(Long projectId) {
        return fromBlueprintDataPopulator.populateAll(blueprintService.listBlueprints(projectId));
    }

    public BlueprintDTO createBlueprint(Long projectId, CreateBlueprintDTO createBlueprintDTO) {
       return fromBlueprintDataPopulator.populate(
               blueprintService.createBlueprint(fromCreateBlueprintDTOPopulator.populate(projectId, createBlueprintDTO))
       );
    }
}
