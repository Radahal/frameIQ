/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.blueprint.controller;

import com.rgosiewski.frameiq.server.blueprint.dto.BlueprintDTO;
import com.rgosiewski.frameiq.server.blueprint.dto.CreateBlueprintDTO;
import com.rgosiewski.frameiq.server.blueprint.facade.BlueprintFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("projects/{projectId}/blueprints/")
public class BlueprintController {
    private final Logger logger = LogManager.getLogger(BlueprintController.class);
    private final BlueprintFacade blueprintFacade;

    public BlueprintController(BlueprintFacade blueprintFacade) {
        this.blueprintFacade = blueprintFacade;
    }

    @GetMapping
    public List<BlueprintDTO> listBlueprints(@PathVariable Long projectId) {
        return blueprintFacade.listBlueprints(projectId);
    }

    @GetMapping("/{blueprintId}")
    public BlueprintDTO getBlueprint(@PathVariable Long blueprintId) {
        return blueprintFacade.getBlueprint(blueprintId);
    }

    @PutMapping
    public BlueprintDTO createBlueprint(@PathVariable Long projectId,
                                      @RequestBody CreateBlueprintDTO createBlueprintDTO) {
        return blueprintFacade.createBlueprint(projectId, createBlueprintDTO);
    }
}
