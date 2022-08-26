/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.database.implementation.model;

import com.rgosiewski.frameiq.database.definition.model.IExifMetadata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "exif_metadata")
public class ExifMetadataEntity extends ModelEntity implements IExifMetadata {

    @Id
    @Column(name = "exif_id")
    private long id;

    @Column(name = "exif_metadata")
    private String metadata;

    @Column(name = "exif_creation_us_id")
    private long creationUsId;

    @Column(name = "exif_creation_time")
    private Date creationTime;

    @Column(name = "exif_modification_us_id")
    private long modificationUsId;

    @Column(name = "exif_modification_time")
    private Date modificationTime;

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
    public String getExifMetadata() {
        return metadata;
    }

    @Override
    public void setExifMetadata(String exifMetadata) {
        this.metadata = metadata;
    }
}
