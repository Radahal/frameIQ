/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.processing.controller;

import com.rgosiewski.frameiq.server.processing.dto.ProcessingDTO;
import com.rgosiewski.frameiq.server.processing.facade.ProcessingFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("processings")
public class ProcessingController {
    private final ProcessingFacade processingFacade;

    public ProcessingController(ProcessingFacade processingFacade) {
        this.processingFacade = processingFacade;
    }

    @GetMapping("/{processingId}")
    public ProcessingDTO getProcessing(@PathVariable Long processingId) {
        return processingFacade.getProcessing(processingId);
    }

    @GetMapping("/all")
    public List<ProcessingDTO> listAll() {
        return processingFacade.listAll();
    }

    @GetMapping("/blueprints/{blueprintId}")
    public List<ProcessingDTO> listAllByBlueprintId(@PathVariable Long blueprintId) {
        return processingFacade.listAllByBlueprintId(blueprintId);
    }
}
