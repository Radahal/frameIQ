package com.rgosiewski.frameiq.database.implementation.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rgosiewski.frameiq.alghorithm.model.FrameProcessedMetadata;
import com.rgosiewski.frameiq.database.definition.repository.FrameMetadataRepository;
import com.rgosiewski.frameiq.database.definition.service.IFrameMetadataService;
import com.rgosiewski.frameiq.database.implementation.model.FrameMetadataEntity;
import com.rgosiewski.frameiq.server.metadata.frameMetadata.data.CreateFrameMetadataData;
import com.rgosiewski.frameiq.server.metadata.frameMetadata.data.FrameMetadataData;
import com.rgosiewski.frameiq.server.metadata.frameMetadata.populator.FrameMetadataDataFromFrameMetadataEntityPopulator;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FrameMetadataService implements IFrameMetadataService {
    private final FrameMetadataRepository frameMetadataRepository;
    private final UserService userService;
    private final FrameMetadataDataFromFrameMetadataEntityPopulator fromFrameMetadataEntityPopulator;

    public FrameMetadataService(FrameMetadataRepository frameMetadataRepository,
                                UserService userService, FrameMetadataDataFromFrameMetadataEntityPopulator fromFrameMetadataEntityPopulator) {
        this.frameMetadataRepository = frameMetadataRepository;
        this.userService = userService;
        this.fromFrameMetadataEntityPopulator = fromFrameMetadataEntityPopulator;
    }


    @Override
    public FrameMetadataData getFrameMetadata(Long frameMetadataId) {
        return fromFrameMetadataEntityPopulator.populate(frameMetadataRepository.getById(frameMetadataId));
    }

    @Override
    public List<FrameMetadataData> listFrameMetadata(Long frameId) {
        return fromFrameMetadataEntityPopulator.populateAll(frameMetadataRepository.findAllByFrameId(frameId));
    }

    @Override
    public FrameMetadataData createFrameMetadata(CreateFrameMetadataData createFrameMetadataData) {
        FrameMetadataEntity entity = new FrameMetadataEntity();
        entity.setCreationTime(new Date());
        entity.setModificationTime(new Date());
        entity.setFrameId(createFrameMetadataData.getFrameId());
        entity.setProcessedMetadata(serializeFrameMetadata(createFrameMetadataData.getMetadata()));
        entity.setExifMetadataId(createFrameMetadataData.getExifMetadataId());
        entity.setCreationUsId(userService.getAdminId());
        entity.setModificationUsId(userService.getAdminId());
        return fromFrameMetadataEntityPopulator.populate(frameMetadataRepository.saveAndFlush(entity));
    }

    private String serializeFrameMetadata(FrameProcessedMetadata frameProcessedMetadata) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(frameProcessedMetadata, FrameProcessedMetadata.class);
    }
}
