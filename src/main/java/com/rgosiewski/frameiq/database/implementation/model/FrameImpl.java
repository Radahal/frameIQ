package com.rgosiewski.frameiq.database.implementation.model;

import com.rgosiewski.frameiq.database.definition.model.IFrame;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "frames")
public class FrameImpl extends ModelImpl implements IFrame {

    @Id
    @Column(name = "fr_id")
    private int id;

    @Column(name = "fr_creation_us_id")
    private int creationUsId;

    @Column(name = "fr_creation_time")
    private Date creationTime;

    @Column(name = "fr_modification_us_id")
    private int modificationUsId;

    @Column(name = "fr_modification_time")
    private Date modificationTime;

    @Column(name = "fr_mov_id")
    private int movieId;

    @Column(name = "fr_ordinal")
    private int ordinal;

    @Column(name = "fr_name")
    private String name;

    @Column(name = "fr_description")
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
    public int getMovieId() {
        return movieId;
    }

    @Override
    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    @Override
    public int getOrdinal() {
        return ordinal;
    }

    @Override
    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
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
