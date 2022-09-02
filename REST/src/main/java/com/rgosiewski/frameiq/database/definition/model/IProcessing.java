package com.rgosiewski.frameiq.database.definition.model;

import java.util.Date;

public interface IProcessing extends IModel {

    long getBlueprintId();

    void setBlueprintId(Long blueprintId);

    String getState();

    void setState(String state);

    Date getStartTime();

    void setStartTime(Date startTime);

    Date getEndTime();

    void setEndTime(Date endTime);
}
