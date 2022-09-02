/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.database.implementation.model;

import com.rgosiewski.frameiq.database.definition.model.IPassword;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "passwords")
public class PasswordEntity extends ModelEntity implements IPassword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pass_id")
    private long id;

    @Column(name = "pass_creation_us_id")
    private long creationUsId;

    @Column(name = "pass_creation_time")
    private Date creationTime;

    @Column(name = "pass_salt")
    private String salt;

    @Column(name = "pass_hash")
    private String hash;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public long getCreationUsId() {
        return creationUsId;
    }

    @Override
    public void setCreationUsId(Long creationUsId) {
        this.creationUsId = creationUsId;
    }

    @Override
    public Date getCreationTime() {
        return creationTime;
    }

    @Override
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String getSalt() {
        return salt;
    }

    @Override
    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String getHash() {
        return hash;
    }

    @Override
    public void setHash(String hash) {
        this.hash = hash;
    }
}
