package com.rgosiewski.frameiq.database.definition.model;

import java.io.Serializable;
import java.util.Date;

public interface IModel extends Serializable {

    int getId();

    void setId(Integer id);

    int getCreationUsId();

    void setCreationUsId(Integer creationUsId);

    Date getCreationDate();

    void setCreationDate(Date creationDate);

    int getModificationUsId();

    void setModificationUsId(Integer modificationUsId);

    Date getModificationDate();

    void setModificationDate(Date modificationDate);
}
