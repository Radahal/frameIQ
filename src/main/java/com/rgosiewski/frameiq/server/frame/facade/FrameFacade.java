/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.frame.facade;

import com.rgosiewski.frameiq.database.implementation.service.FrameService;
import com.rgosiewski.frameiq.server.common.stereotype.Facade;
import com.rgosiewski.frameiq.server.frame.dto.CreateFrameDTO;
import com.rgosiewski.frameiq.server.frame.dto.EditFrameDTO;
import com.rgosiewski.frameiq.server.frame.dto.FrameDTO;
import com.rgosiewski.frameiq.server.frame.populator.CreateFrameDataFromCreateFrameDTOPopulator;
import com.rgosiewski.frameiq.server.frame.populator.EditFrameDataFromEditFrameDTOPopulator;
import com.rgosiewski.frameiq.server.frame.populator.FrameDTOFromFrameDataPopulator;

import java.util.List;

@Facade
public class FrameFacade {
    private final FrameService frameService;
    private final FrameDTOFromFrameDataPopulator fromFrameDataPopulator;
    private final CreateFrameDataFromCreateFrameDTOPopulator fromCreateFrameDTOPopulator;
    private final EditFrameDataFromEditFrameDTOPopulator fromEditFrameDTOPopulator;

    public FrameFacade(FrameService frameService,
                       FrameDTOFromFrameDataPopulator fromFrameDataPopulator,
                       CreateFrameDataFromCreateFrameDTOPopulator fromCreateFrameDTOPopulator,
                       EditFrameDataFromEditFrameDTOPopulator fromEditFrameDTOPopulator) {
        this.frameService = frameService;
        this.fromFrameDataPopulator = fromFrameDataPopulator;
        this.fromCreateFrameDTOPopulator = fromCreateFrameDTOPopulator;
        this.fromEditFrameDTOPopulator = fromEditFrameDTOPopulator;
    }

    public FrameDTO getFrame(Long frameId) {
        return fromFrameDataPopulator.populate(frameService.getFrame(frameId));
    }

    public List<FrameDTO> listMovieFrames(Long movieId) {
        return fromFrameDataPopulator.populateAll(frameService.listAllByMovieId(movieId));
    }

    public FrameDTO createFrame(Long movieId, CreateFrameDTO createFrameDTO) {
       return fromFrameDataPopulator.populate(
               frameService.createFrame(fromCreateFrameDTOPopulator.populate(movieId, createFrameDTO))
       );
    }

    public FrameDTO editFrame(Long frameId, EditFrameDTO editFrameDTO) {
        return fromFrameDataPopulator.populate(
                frameService.editFrame(fromEditFrameDTOPopulator.populate(frameId, editFrameDTO))
        );
    }
}
