package com.rgosiewski.frameiq.database.definition.model;

public interface IMovieMetadata extends IModel {

    long getMovieId();

    void setMovieId(Long movieId);

    long getExifMetadataId();

    void setExifMetadataId(Long exifMetadataId);

    String getProcessedMetadata();

    void setProcessedMetadata(String metadata);
}
