package com.rgosiewski.frameiq.database.implementation.model;

import com.rgosiewski.frameiq.database.definition.model.IModel;
import com.rgosiewski.frameiq.database.exception.ActionNotAvailableException;

import java.util.Date;

public class ModelImpl implements IModel {
    @Override
    public int getId() {
        throw new ActionNotAvailableException();
    }

    @Override
    public void setId(Integer id) {
        throw new ActionNotAvailableException();
    }

    @Override
    public int getUsIdInserted() {
        throw new ActionNotAvailableException();
    }

    @Override
    public void setUsIdInserted(Integer usIdInserted) {
        throw new ActionNotAvailableException();
    }

    @Override
    public Date getDateInserted() {
        throw new ActionNotAvailableException();
    }

    @Override
    public void setDateInserted(Date dateInserted) {
        throw new ActionNotAvailableException();
    }

    @Override
    public int getUsIdModified() {
        throw new ActionNotAvailableException();
    }

    @Override
    public void setUsIdModified(Integer usIdModified) {
        throw new ActionNotAvailableException();
    }

    @Override
    public Date getDateModified() {
        throw new ActionNotAvailableException();
    }

    @Override
    public void setDateModified(Date dateModified) {
        throw new ActionNotAvailableException();
    }
}
