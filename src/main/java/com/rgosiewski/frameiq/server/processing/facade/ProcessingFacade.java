/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.processing.facade;

import com.rgosiewski.frameiq.database.implementation.service.ProcessingService;
import com.rgosiewski.frameiq.server.common.stereotype.Facade;
import com.rgosiewski.frameiq.server.processing.dto.ProcessingDTO;
import com.rgosiewski.frameiq.server.processing.populator.ProcessingDTOFromProcessingDataPopulator;

import java.util.List;

@Facade
public class ProcessingFacade {
    private final ProcessingService processingService;
    private final ProcessingDTOFromProcessingDataPopulator fromProcessingDataPopulator;

    public ProcessingFacade(ProcessingService processingService,
                            ProcessingDTOFromProcessingDataPopulator fromProcessingDataPopulator) {
        this.processingService = processingService;
        this.fromProcessingDataPopulator = fromProcessingDataPopulator;
    }

    public ProcessingDTO getProcessing(Long processingId) {
        return fromProcessingDataPopulator.populate(processingService.getProcessing(processingId));
    }

    public List<ProcessingDTO> listAllByBlueprintId(Long blueprintId) {
        return fromProcessingDataPopulator.populateAll(processingService.listAllByBlueprintId(blueprintId));
    }

    public List<ProcessingDTO> listAll() {
        return fromProcessingDataPopulator.populateAll(processingService.listAll());
    }
}
