package com.rgosiewski.frameiq.database.definition.model;

import java.io.Serializable;
import java.util.Date;

public interface IModel extends Serializable {

    int getId();

    void setId(Integer id);

    int getCreationUsId();

    void setCreationUsId(Integer creationUsId);

    Date getCreationTime();

    void setCreationTime(Date creationTime);

    int getModificationUsId();

    void setModificationUsId(Integer modificationUsId);

    Date getModificationTime();

    void setModificationTime(Date modificationTime);
}
