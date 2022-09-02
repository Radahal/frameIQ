package com.rgosiewski.frameiq.database.definition.model;

public interface IFrameMetadata extends IModel {

    long getFrameId();

    void setFrameId(Long frameId);

    long getExifMetadataId();

    void setExifMetadataId(Long exifMetadataId);

    String getProcessedMetadata();

    void setProcessedMetadata(String processedMetadata);
}
