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
    private final ExifMetadataDataFromExifMetadataEntityPopulator fromExifMetadataEntityPopulator;

    public ExifMetadataService(ExifMetadataRepository exifMetadataRepository,
                               ExifMetadataDataFromExifMetadataEntityPopulator fromExifMetadataEntityPopulator) {
        this.exifMetadataRepository = exifMetadataRepository;
        this.fromExifMetadataEntityPopulator = fromExifMetadataEntityPopulator;
    }

    @Override
    public ExifMetadataData getExifMetadata(Long exifMetadataId) {
        return fromExifMetadataEntityPopulator.populate(exifMetadataRepository.getById(exifMetadataId));
    }

    @Override
    public ExifMetadataData createExifMetadata(CreateExifMetadataData createExifMetadataData) {
        ExifMetadataEntity entity = new ExifMetadataEntity();
        entity.setCreationTime(new Date());
        entity.setModificationTime(new Date());
        entity.setExifMetadata(createExifMetadataData.getMetadata());
        return fromExifMetadataEntityPopulator.populate(exifMetadataRepository.saveAndFlush(entity));
    }
}
