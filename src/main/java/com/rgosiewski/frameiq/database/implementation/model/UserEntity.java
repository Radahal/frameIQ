/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.database.implementation.model;

import com.rgosiewski.frameiq.database.definition.model.IUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "users")
public class UserEntity extends ModelEntity implements IUser {

    @Id
    @Column(name = "us_id")
    private long id;

    @Column(name = "us_creation_us_id")
    private long creationUsId;

    @Column(name = "us_creation_time")
    private Date creationTime;

    @Column(name = "us_modification_us_id")
    private long modificationUsId;

    @Column(name = "us_modification_time")
    private Date modificationTime;

    @Column(name = "us_name")
    private String name;

    @Column(name = "us_first_name")
    private String firstName;

    @Column(name = "us_last_name")
    private String lastName;

    @Column(name = "us_gender")
    private String gender;

    @Column(name = "us_email")
    private String email;

    @Column(name = "us_pass_id")
    private long passwordId;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public long getCreationUsId() {
        return this.creationUsId;
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
    public long getModificationUsId() {
        return modificationUsId;
    }

    @Override
    public void setModificationUsId(Long modificationUsId) {
        this.modificationUsId = modificationUsId;
    }

    @Override
    public Date getModificationTime() {
        return modificationTime;
    }

    @Override
    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public long getPasswordId() {
        return passwordId;
    }

    @Override
    public void setPasswordId(Long passwordId) {
        this.passwordId = passwordId;
    }
}
