/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.database.implementation.model;

import com.rgosiewski.frameiq.database.definition.model.IModel;
import com.rgosiewski.frameiq.database.exception.ActionNotAvailableException;

import java.util.Date;

public class ModelEntity implements IModel {

    @Override
    public long getId() {
        throw new ActionNotAvailableException();
    }

    @Override
    public void setId(Long id) {
        throw new ActionNotAvailableException();
    }

    @Override
    public long getCreationUsId() {
        throw new ActionNotAvailableException();
    }

    @Override
    public void setCreationUsId(Long creationUsId) {
        throw new ActionNotAvailableException();
    }

    @Override
    public Date getCreationTime() {
        throw new ActionNotAvailableException();
    }

    @Override
    public void setCreationTime(Date creationTime) {
        throw new ActionNotAvailableException();
    }

    @Override
    public long getModificationUsId() {
        throw new ActionNotAvailableException();
    }

    @Override
    public void setModificationUsId(Long modificationUsId) {
        throw new ActionNotAvailableException();
    }

    @Override
    public Date getModificationTime() {
        throw new ActionNotAvailableException();
    }

    @Override
    public void setModificationTime(Date modificationTime) {
        throw new ActionNotAvailableException();
    }
}
