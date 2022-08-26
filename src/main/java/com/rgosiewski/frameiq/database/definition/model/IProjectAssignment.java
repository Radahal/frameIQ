package com.rgosiewski.frameiq.database.definition.model;

public interface IProjectAssignment extends IModel {

    long getUserId();

    void setUserId(Long userId);

    long getProjectId();

    void setProjectId(Long projectId);
}
