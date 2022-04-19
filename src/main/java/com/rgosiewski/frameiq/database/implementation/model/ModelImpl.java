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
    public int getCreationUsId() {
        throw new ActionNotAvailableException();
    }

    @Override
    public void setCreationUsId(Integer creationUsId) {
        throw new ActionNotAvailableException();
    }

    @Override
    public Date getCreationDate() {
        throw new ActionNotAvailableException();
    }

    @Override
    public void setCreationDate(Date creationDate) {
        throw new ActionNotAvailableException();
    }

    @Override
    public int getModificationUsId() {
        throw new ActionNotAvailableException();
    }

    @Override
    public void setModificationUsId(Integer modificationUsId) {
        throw new ActionNotAvailableException();
    }

    @Override
    public Date getModificationDate() {
        throw new ActionNotAvailableException();
    }

    @Override
    public void setModificationDate(Date modificationDate) {
        throw new ActionNotAvailableException();
    }
}
