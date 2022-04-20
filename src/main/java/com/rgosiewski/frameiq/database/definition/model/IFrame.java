package com.rgosiewski.frameiq.database.definition.model;

public interface IFrame extends IModel {

    int getMovieId();

    void setMovieId(Integer movieId);

    int getOrdinal();

    void setOrdinal(Integer ordinal);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);
}
