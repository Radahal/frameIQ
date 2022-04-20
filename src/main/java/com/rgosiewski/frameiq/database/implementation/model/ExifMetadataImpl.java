package com.rgosiewski.frameiq.database.implementation.model;

import com.rgosiewski.frameiq.database.definition.model.IExifMetadata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "exif_metadata")
public class ExifMetadataImpl extends ModelImpl implements IExifMetadata {

    @Id
    @Column(name = "exif_id")
    private int id;

    @Column(name = "exif_metadata")
    private String metadata;

    @Column(name = "exif_creation_us_id")
    private int creationUsId;

    @Column(name = "exif_creation_time")
    private Date creationTime;

    @Column(name = "exif_modification_us_id")
    private int modificationUsId;

    @Column(name = "exif_modification_time")
    private Date modificationTime;

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
    public String getExifMetadata() {
        return metadata;
    }

    @Override
    public void setExifMetadata(String exifMetadata) {
        this.metadata = metadata;
    }
}
