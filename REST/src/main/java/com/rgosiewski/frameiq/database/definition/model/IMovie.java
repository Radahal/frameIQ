package com.rgosiewski.frameiq.database.definition.model;

public interface IMovie extends IModel {

    long getBlueprintId();

    void setBlueprintId(Long blueprintId);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);
}
