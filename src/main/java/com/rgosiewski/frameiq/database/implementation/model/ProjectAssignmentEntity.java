/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.database.implementation.model;

import com.rgosiewski.frameiq.database.definition.model.IProjectAssignment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "project_assignments")
public class ProjectAssignmentEntity extends ModelEntity implements IProjectAssignment {

    @Id
    @Column(name = "proja_id")
    private long id;

    @Column(name = "proja_creation_us_id")
    private long creationUsId;

    @Column(name = "proja_creation_time")
    private Date creationTime;

    @Column(name = "proja_modification_us_id")
    private long modificationUsId;

    @Column(name = "proja_modification_time")
    private Date modificationTime;

    @Column(name = "proja_us_id")
    private long userId;

    @Column(name = "proja_proj_id")
    private long projectId;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public long getCreationUsId() {
        return creationUsId;
    }

    @Override
    public void setCreationUsId(Long creationUsId) {
        this.creationUsId = creationUsId;
    }

    @Override
    public Date getCreationTime() {
        return creationTime;
    }

    @Override
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public long getModificationUsId() {
        return modificationUsId;
    }

    @Override
    public void setModificationUsId(Long modificationUsId) {
        this.modificationUsId = modificationUsId;
    }

    @Override
    public Date getModificationTime() {
        return modificationTime;
    }

    @Override
    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    @Override
    public long getUserId() {
        return userId;
    }

    @Override
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public long getProjectId() {
        return projectId;
    }

    @Override
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
