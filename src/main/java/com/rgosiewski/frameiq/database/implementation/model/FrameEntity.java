package com.rgosiewski.frameiq.database.implementation.model;

import com.rgosiewski.frameiq.database.definition.model.IFrame;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "frames")
public class FrameEntity extends ModelEntity implements IFrame {

    @Id
    @Column(name = "fr_id")
    private int id;

    @Column(name = "fr_creation_us_id")
    private long creationUsId;

    @Column(name = "fr_creation_time")
    private Date creationTime;

    @Column(name = "fr_modification_us_id")
    private long modificationUsId;

    @Column(name = "fr_modification_time")
    private Date modificationTime;

    @Column(name = "fr_mov_id")
    private long movieId;

    @Column(name = "fr_ordinal")
    private int ordinal;

    @Column(name = "fr_name")
    private String name;

    @Column(name = "fr_description")
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
    public long getMovieId() {
        return movieId;
    }

    @Override
    public void setMovieId(Long movieId) {
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
