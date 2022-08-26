/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.database.implementation.model;

import com.rgosiewski.frameiq.database.definition.model.IMovie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "movies")
public class MovieEntity extends ModelEntity implements IMovie {

    @Id
    @Column(name = "mov_id")
    private long id;

    @Column(name = "mov_creation_us_id")
    private long creationUsId;

    @Column(name = "mov_creation_time")
    private Date creationTime;

    @Column(name = "mov_modification_us_id")
    private long modificationUsId;

    @Column(name = "mov_modification_time")
    private Date modificationTime;

    @Column(name = "mov_bp_id")
    private long blueprintId;

    @Column(name = "mov_name")
    private String name;

    @Column(name = "mov_description")
    private String description;

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
    public long getBlueprintId() {
        return blueprintId;
    }

    @Override
    public void setBlueprintId(Long blueprintId) {
        this.blueprintId = blueprintId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
