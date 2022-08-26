/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.metadata.frameMetadata.controller;

import com.rgosiewski.frameiq.server.metadata.frameMetadata.dto.FrameMetadataDTO;
import com.rgosiewski.frameiq.server.metadata.frameMetadata.facade.FrameMetadataFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("frames/{frameId}/metadata")
public class FrameMetadataController {
    private final Logger logger = LogManager.getLogger(FrameMetadataController.class);
    private final FrameMetadataFacade frameMetadataFacade;

    public FrameMetadataController(FrameMetadataFacade frameMetadataFacade) {
        this.frameMetadataFacade = frameMetadataFacade;
    }

    @GetMapping
    public List<FrameMetadataDTO> listAllFrameMetadata(@PathVariable Long frameId) {
        return frameMetadataFacade.listAllByFrameId(frameId);
    }

    @GetMapping("/{frameMetadataId}")
    public FrameMetadataDTO getFrameMetadata(@PathVariable Long frameMetadataId) {
        return frameMetadataFacade.getFrameMetadata(frameMetadataId);
    }
}