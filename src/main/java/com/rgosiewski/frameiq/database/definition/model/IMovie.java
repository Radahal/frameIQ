package com.rgosiewski.frameiq.database.definition.model;

public interface IMovie extends IModel {

    int getBlueprintId();

    void setBlueprintId(Integer blueprintId);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);
}
