/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rgosiewski.frameiq.server.common.stereotype.DTO;

import java.util.Date;

@DTO
public class IDTO {
    private final Long id;
    private final Long creationUsId;
    private final Long modificationUsId;
    private final Date creationTime;
    private final Date modificationTime;

    public IDTO(@JsonProperty("id") Long id,
                @JsonProperty("creationUsId") Long creationUsId,
                @JsonProperty("modificationUsId") Long modificationUsId,
                @JsonProperty("creationTime") Date creationTime,
                @JsonProperty("modificationTime") Date modificationTime) {
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
