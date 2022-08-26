/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.database.implementation.model;

import com.rgosiewski.frameiq.database.definition.model.IConfiguration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "configurations")
public class ConfigurationEntity extends ModelEntity implements IConfiguration {

    @Id
    @Column(name = "conf_id")
    private long id;

    @Column(name = "conf_proj_id")
    private long projectId;

    @Column(name = "conf_name")
    private String name;

    @Column(name = "conf_description")
    private String description;

    @Column(name = "conf_creation_time")
    private Date creationTime;

    @Column(name = "conf_modification_time")
    private Date modificationTime;

    @Column(name ="conf_creation_us_id")
    private long creationUsId;

    @Column(name ="conf_modification_us_id")
    private long modificationUsId;

    @Column(name = "conf_tag")
    private String tag;

    @Column(name = "conf_input_filename")
    private String inputFileName;

    @Column(name = "conf_algorithm")
    private String algorithm;

    @Column(name = "conf_algorithm_properties")
    private String algorithmProperties;

    @Column(name = "conf_strategy")
    private String strategy;

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
    public long getProjectId() {
        return projectId;
    }

    @Override
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
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
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String getInputFileName() {
        return inputFileName;
    }

    @Override
    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    @Override
    public String getAlgorithm() {
        return algorithm;
    }

    @Override
    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public String getAlgorithmProperties() {
        return algorithmProperties;
    }

    @Override
    public void setAlgorithmProperties(String algorithmProperties) {
        this.algorithmProperties = algorithmProperties;
    }

    @Override
    public String getStrategy() {
        return strategy;
    }

    @Override
    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }
}
