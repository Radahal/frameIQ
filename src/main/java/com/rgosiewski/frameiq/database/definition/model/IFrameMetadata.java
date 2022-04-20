package com.rgosiewski.frameiq.database.definition.model;

public interface IFrameMetadata extends IModel {

    int getFrameId();

    void setFrameId(Integer frameId);

    int getExifMetadataId();

    void setExifMetadataId(Integer exifMetadataId);

    String getProcessedMetadata();

    void setProcessedMetadata(String processedMetadata);
}
