package com.rgosiewski.frameiq.database.implementation.service;

import com.rgosiewski.frameiq.database.definition.repository.FrameRepository;
import com.rgosiewski.frameiq.database.definition.service.IFrameService;
import com.rgosiewski.frameiq.database.implementation.model.FrameEntity;
import com.rgosiewski.frameiq.server.frame.data.CreateFrameData;
import com.rgosiewski.frameiq.server.frame.data.EditFrameData;
import com.rgosiewski.frameiq.server.frame.data.FrameData;
import com.rgosiewski.frameiq.server.frame.populator.FrameDataFromFrameEntityPopulator;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FrameService implements IFrameService {
    private final FrameRepository frameRepository;
    private final UserService userService;
    private final FrameDataFromFrameEntityPopulator fromFrameEntityPopulator;

    public FrameService(FrameRepository frameRepository,
                        UserService userService, FrameDataFromFrameEntityPopulator fromFrameEntityPopulator) {
        this.frameRepository = frameRepository;
        this.userService = userService;
        this.fromFrameEntityPopulator = fromFrameEntityPopulator;
    }

    @Override
    public FrameData getFrame(Long frameId) {
        return fromFrameEntityPopulator.populate(frameRepository.getById(frameId));
    }

    @Override
    public List<FrameData> listAllByMovieId(Long movieId) {
        return fromFrameEntityPopulator.populateAll(frameRepository.findAllByMovieId(movieId));
    }

    @Override
    public FrameData createFrame(CreateFrameData createFrameData) {
        FrameEntity entity = new FrameEntity();
        entity.setMovieId(createFrameData.getMovieId());
        entity.setName(createFrameData.getName());
        entity.setOrdinal(createFrameData.getOrdinal());
        entity.setDescription(createFrameData.getDescription());
        entity.setCreationTime(new Date());
        entity.setModificationTime(new Date());
        entity.setCreationUsId(userService.getAdminId());
        entity.setModificationUsId(userService.getAdminId());
        return fromFrameEntityPopulator.populate(frameRepository.saveAndFlush(entity));
    }

    @Override
    public FrameData editFrame(EditFrameData editFrameData) {
        FrameEntity entity = frameRepository.getById(editFrameData.getFrameId());
        entity.setName(editFrameData.getName());
        entity.setDescription(editFrameData.getDescription());
        entity.setModificationTime(new Date());
        entity.setModificationUsId(userService.getAdminId());
        return fromFrameEntityPopulator.populate(frameRepository.saveAndFlush(entity));
    }
}
