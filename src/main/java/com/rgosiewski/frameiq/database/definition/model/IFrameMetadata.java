package com.rgosiewski.frameiq.database.definition.model;

public interface IFrameMetadata extends IModel {

    int getFrameId();

    void setFrameId(int frameId);

    int getExifMetadataId();

    void setExifMetadataId(int exifMetadataId);

    String getProcessedMetadata();

    void setProcessedMetadata(String processedMetadata);
}
