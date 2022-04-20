package com.rgosiewski.frameiq.database.definition.model;

public interface IProjectAssignment extends IModel {

    int getUserId();

    void setUserId(Integer userId);

    int getProjectId();

    void setProjectId(Integer projectId);
}
