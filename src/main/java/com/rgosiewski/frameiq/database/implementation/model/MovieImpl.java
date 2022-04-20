package com.rgosiewski.frameiq.database.implementation.model;

import com.rgosiewski.frameiq.database.definition.model.IMovie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "movies")
public class MovieImpl extends ModelImpl implements IMovie {

    @Id
    @Column(name = "mov_id")
    private int id;

    @Column(name = "mov_creation_us_id")
    private int creationUsId;

    @Column(name = "mov_creation_time")
    private Date creationTime;

    @Column(name = "mov_modification_us_id")
    private int modificationUsId;

    @Column(name = "mov_modification_time")
    private Date modificationTime;

    @Column(name = "mov_bp_id")
    private int blueprintId;

    @Column(name = "mov_name")
    private String name;

    @Column(name = "mov_description")
    private String description;

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
    public int getBlueprintId() {
        return blueprintId;
    }

    @Override
    public void setBlueprintId(Integer blueprintId) {
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
