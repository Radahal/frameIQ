package com.rgosiewski.frameiq.database.definition.model;

public interface IMovieMetadata extends IModel {

    int getMovieId();

    void setMovieId(int movieId);

    int getExifMetadataId();

    void setExifMetadataId(int exifMetadataId);

    String getProcessedMetadata();

    void setProcessedMetadata(String processedMetadata);
}
