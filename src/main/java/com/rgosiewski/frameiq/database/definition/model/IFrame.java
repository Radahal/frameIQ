package com.rgosiewski.frameiq.database.definition.model;

public interface IFrame extends IModel {

    long getMovieId();

    void setMovieId(Long movieId);

    int getOrdinal();

    void setOrdinal(Integer ordinal);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);
}
