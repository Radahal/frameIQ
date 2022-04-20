package com.rgosiewski.frameiq.database.implementation.model;

import com.rgosiewski.frameiq.database.definition.model.IProjectAssignment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "project_assignments")
public class ProjectAssignmentImpl extends ModelImpl implements IProjectAssignment {

    @Id
    @Column(name = "proc_id")
    private int id;

    @Column(name = "proc_creation_us_id")
    private int creationUsId;

    @Column(name = "proc_creation_time")
    private Date creationTime;

    @Column(name = "proc_modification_us_id")
    private int modificationUsId;

    @Column(name = "proc_modification_time")
    private Date modificationTime;

    @Column(name = "proja_us_id")
    private int userId;

    @Column(name = "proja_proj_id")
    private int projectId;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getCreationUsId() {
        return creationUsId;
    }

    @Override
    public void setCreationUsId(Integer creationUsId) {
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
    public int getModificationUsId() {
        return modificationUsId;
    }

    @Override
    public void setModificationUsId(Integer modificationUsId) {
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
    public int getUserId() {
        return userId;
    }

    @Override
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public int getProjectId() {
        return projectId;
    }

    @Override
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
