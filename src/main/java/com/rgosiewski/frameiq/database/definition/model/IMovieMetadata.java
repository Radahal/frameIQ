package com.rgosiewski.frameiq.database.definition.model;

public interface IMovieMetadata extends IModel {

    int getMovieId();

    void setMovieId(Integer movieId);

    int getExifMetadataId();

    void setExifMetadataId(Integer exifMetadataId);

    String getProcessedMetadata();

    void setProcessedMetadata(String metadata);
}
