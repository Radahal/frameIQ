package com.rgosiewski.frameiq.database.implementation.service;

import com.rgosiewski.frameiq.database.definition.repository.ExifMetadataRepository;
import com.rgosiewski.frameiq.database.definition.service.IExifMetadataService;
import com.rgosiewski.frameiq.database.implementation.model.ExifMetadataEntity;
import com.rgosiewski.frameiq.server.metadata.exifMetadata.data.CreateExifMetadataData;
import com.rgosiewski.frameiq.server.metadata.exifMetadata.data.ExifMetadataData;
import com.rgosiewski.frameiq.server.metadata.exifMetadata.populator.ExifMetadataDataFromExifMetadataEntityPopulator;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ExifMetadataService implements IExifMetadataService {
    private final ExifMetadataRepository exifMetadataRepository;
    private final UserService userService;
    private final ExifMetadataDataFromExifMetadataEntityPopulator fromExifMetadataEntityPopulator;

    public ExifMetadataService(ExifMetadataRepository exifMetadataRepository,
                               UserService userService, ExifMetadataDataFromExifMetadataEntityPopulator fromExifMetadataEntityPopulator) {
        this.exifMetadataRepository = exifMetadataRepository;
        this.userService = userService;
        this.fromExifMetadataEntityPopulator = fromExifMetadataEntityPopulator;
    }

    @Override
    public ExifMetadataData getExifMetadata(Long exifMetadataId) {
        return fromExifMetadataEntityPopulator.populate(exifMetadataRepository.getById(exifMetadataId));
    }

    @Override
    public ExifMetadataData createExifMetadata(CreateExifMetadataData createExifMetadataData) {
        ExifMetadataEntity entity = new ExifMetadataEntity();
        entity.setExifMetadata(createExifMetadataData.getMetadata());
        entity.setCreationTime(new Date());
        entity.setModificationTime(new Date());
        entity.setCreationUsId(userService.getAdminId());
        entity.setModificationUsId(userService.getAdminId());
        return fromExifMetadataEntityPopulator.populate(exifMetadataRepository.saveAndFlush(entity));
    }
}
