/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.database.implementation.model;

import com.rgosiewski.frameiq.database.definition.model.IFrameMetadata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "frame_metadata")
public class FrameMetadataEntity extends ModelEntity implements IFrameMetadata {

    @Id
    @Column(name = "frm_id")
    private long id;

    @Column(name = "frm_creation_us_id")
    private long creationUsId;

    @Column(name = "frm_creation_time")
    private Date creationTime;

    @Column(name = "frm_modification_us_id")
    private long modificationUsId;

    @Column(name = "frm_modification_time")
    private Date modificationTime;

    @Column(name = "frm_fr_id")
    private long frameId;

    @Column(name = "frm_exif_id")
    private long exifMetadataId;

    @Column(name = "frm_metadata")
    private String processedMetadata;

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
    public long getFrameId() {
        return frameId;
    }

    @Override
    public void setFrameId(Long frameId) {
        this.frameId = frameId;
    }

    @Override
    public long getExifMetadataId() {
        return exifMetadataId;
    }

    @Override
    public void setExifMetadataId(Long exifMetadataId) {
        this.exifMetadataId = exifMetadataId;
    }

    @Override
    public String getProcessedMetadata() {
        return processedMetadata;
    }

    @Override
    public void setProcessedMetadata(String processedMetadata) {
        this.processedMetadata = processedMetadata;
    }
}
