/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.common.data;

import java.util.Date;

public class IData {
    private final Long id;
    private final Long creationUsId;
    private final Long modificationUsId;
    private final Date creationTime;
    private final Date modificationTime;

    public IData(Long id, Long creationUsId, Long modificationUsId, Date creationTime, Date modificationTime) {
        this.id = id;
        this.creationUsId = creationUsId;
        this.modificationUsId = modificationUsId;
        this.creationTime = creationTime;
        this.modificationTime = modificationTime;
    }

    public Long getId() {
        return id;
    }

    public Long getCreationUsId() {
        return creationUsId;
    }

    public Long getModificationUsId() {
        return modificationUsId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public Date getModificationTime() {
        return modificationTime;
    }
}
