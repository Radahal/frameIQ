package com.rgosiewski.frameiq.database.definition.model;

import java.io.Serializable;
import java.util.Date;

public interface IModel extends Serializable {

    int getId();

    void setId(Integer id);

    int getUsIdInserted();

    void setUsIdInserted(Integer usIdInserted);

    Date getDateInserted();

    void setDateInserted(Date dateInserted);

    int getUsIdModified();

    void setUsIdModified(Integer usIdModified);

    Date getDateModified();

    void setDateModified(Date dateModified);
}
