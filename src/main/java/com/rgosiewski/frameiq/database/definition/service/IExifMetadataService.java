package com.rgosiewski.frameiq.database.definition.service;

import com.rgosiewski.frameiq.server.metadata.exifMetadata.data.CreateExifMetadataData;
import com.rgosiewski.frameiq.server.metadata.exifMetadata.data.ExifMetadataData;
import org.springframework.stereotype.Service;

@Service
public interface IExifMetadataService {

    public ExifMetadataData getExifMetadata(Long exifMetadataId);

    public ExifMetadataData createExifMetadata(CreateExifMetadataData createExifMetadataData);
}
