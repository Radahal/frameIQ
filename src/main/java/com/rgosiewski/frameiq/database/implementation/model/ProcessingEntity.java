package com.rgosiewski.frameiq.database.implementation.model;

import com.rgosiewski.frameiq.database.definition.model.IProcessing;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "processings")
public class ProcessingEntity extends ModelEntity implements IProcessing {

    @Id
    @Column(name = "proc_id")
    private long id;

    @Column(name = "proc_creation_us_id")
    private long creationUsId;

    @Column(name = "proc_creation_time")
    private Date creationTime;

    @Column(name = "proc_modification_us_id")
    private long modificationUsId;

    @Column(name = "proc_modification_time")
    private Date modificationTime;

    @Column(name = "proc_bp_id")
    private long blueprintId;

    @Column(name = "proc_state")
    private String state;

    @Column(name = "proc_start_time")
    private Date startTime;

    @Column(name = "proc_end_time")
    private Date endTime;

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
    public String getState() {
        return state;
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public Date getStartTime() {
        return startTime;
    }

    @Override
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public Date getEndTime() {
        return endTime;
    }

    @Override
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
