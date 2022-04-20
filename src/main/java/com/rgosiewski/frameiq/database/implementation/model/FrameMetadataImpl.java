package com.rgosiewski.frameiq.database.implementation.model;

import com.rgosiewski.frameiq.database.definition.model.IFrameMetadata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "frame_metadata")
public class FrameMetadataImpl extends ModelImpl implements IFrameMetadata {

    @Id
    @Column(name = "frm_id")
    private int id;

    @Column(name = "frm_creation_us_id")
    private int creationUsId;

    @Column(name = "frm_creation_time")
    private Date creationTime;

    @Column(name = "frm_modification_us_id")
    private int modificationUsId;

    @Column(name = "frm_modification_time")
    private Date modificationTime;

    @Column(name = "frm_fr_id")
    private int frameId;

    @Column(name = "frm_exif_id")
    private int exifMetadataId;

    @Column(name = "frm_metadata")
    private String processedMetadata;

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
    public int getFrameId() {
        return frameId;
    }

    @Override
    public void setFrameId(Integer frameId) {
        this.frameId = frameId;
    }

    @Override
    public int getExifMetadataId() {
        return exifMetadataId;
    }

    @Override
    public void setExifMetadataId(Integer exifMetadataId) {
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
