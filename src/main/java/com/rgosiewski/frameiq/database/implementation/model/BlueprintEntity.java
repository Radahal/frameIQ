package com.rgosiewski.frameiq.database.implementation.model;

import com.rgosiewski.frameiq.database.definition.model.IBlueprint;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "blueprints")
public class BlueprintEntity extends ModelEntity implements IBlueprint {

    @Id
    @Column(name = "bp_id")
    private long id;

    @Column(name = "bp_conf_id")
    private long configurationId;

    @Column(name = "bp_name")
    private String name;

    @Column(name = "bp_description")
    private String description;

    @Column(name = "bp_tag")
    private String tag;

    @Column(name = "bp_input_filename")
    private String inputFileName;

    @Column(name = "bp_algorithm")
    private String algorithm;

    @Column(name = "bp_algorithm_properties")
    private String algorithmProperties;

    @Column(name = "bp_strategy")
    private String strategy;

    @Column(name = "bp_creation_us_id")
    private long creationUserId;

    @Column(name = "bp_modification_us_id")
    private long modificationUsId;

    @Column(name = "bp_creation_time")
    private Date creationTime;

    @Column(name ="bp_modification_time")
    private Date modificationTime;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public long getCreationUsId() {
        return creationUserId;
    }

    @Override
    public void setCreationUsId(Long creationUsId) {
        this.creationUserId = creationUsId;
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
    public long getConfigurationId() {
        return configurationId;
    }

    @Override
    public void setConfigurationId(Long configurationId) {
        this.configurationId = configurationId;
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
    public String getStrategy() {
        return strategy;
    }

    @Override
    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    @Override
    public String getAlgorithmProperties() {
        return algorithmProperties;
    }

    @Override
    public void setAlgorithmProperties(String algorithmProperties) {
        this.algorithmProperties = algorithmProperties;
    }

}
