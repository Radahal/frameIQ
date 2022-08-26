package com.rgosiewski.frameiq.database.definition.model;

import java.io.Serializable;
import java.util.Date;

public interface IModel extends Serializable {

    long getId();

    void setId(Long id);

    long getCreationUsId();

    void setCreationUsId(Long creationUsId);

    Date getCreationTime();

    void setCreationTime(Date creationTime);

    long getModificationUsId();

    void setModificationUsId(Long modificationUsId);

    Date getModificationTime();

    void setModificationTime(Date modificationTime);
}
