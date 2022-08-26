/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.frame.controller;

import com.rgosiewski.frameiq.server.frame.dto.CreateFrameDTO;
import com.rgosiewski.frameiq.server.frame.dto.EditFrameDTO;
import com.rgosiewski.frameiq.server.frame.dto.FrameDTO;
import com.rgosiewski.frameiq.server.frame.facade.FrameFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies/{movieId}/frames/")
public class FrameController {
    private final Logger logger = LogManager.getLogger(FrameController.class);
    private final FrameFacade frameFacade;

    public FrameController(FrameFacade frameFacade) {
        this.frameFacade = frameFacade;
    }

    @GetMapping()
    public List<FrameDTO> listFrames(@PathVariable Long movieId) {
        return frameFacade.listMovieFrames(movieId);
    }

    @GetMapping("/{frameId}")
    public FrameDTO getFrame(@PathVariable Long frameId) {
        return frameFacade.getFrame(frameId);
    }

    @PutMapping
    public FrameDTO createFrame(@PathVariable Long movieId,
                                @RequestBody CreateFrameDTO createFrameDTO) {
        return frameFacade.createFrame(movieId, createFrameDTO);
    }

    @PatchMapping("/{frameId}")
    public FrameDTO editFrame(@PathVariable Long frameId,
                              @RequestBody EditFrameDTO editFrameDTO) {
        return frameFacade.editFrame(frameId, editFrameDTO);
    }

}
