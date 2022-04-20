package com.rgosiewski.frameiq.database.implementation.model;

import com.rgosiewski.frameiq.database.definition.model.IConfiguration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "configurations")
public class ConfigurationImpl extends ModelImpl implements IConfiguration {

    @Id
    @Column(name = "conf_id")
    private int id;

    @Column(name = "conf_proj_id")
    private int projectId;

    @Column(name = "conf_name")
    private String name;

    @Column(name = "conf_description")
    private String description;

    @Column(name = "conf_creation_time")
    private Date creationTime;

    @Column(name = "conf_modification_time")
    private Date modificationTime;

    @Column(name ="conf_creation_us_id")
    private int creationUsId;

    @Column(name ="conf_modification_us_id")
    private int modificationUsId;

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
    public int getId() {
        return id;
    }

    @Override
    public int getCreationUsId() {
        return creationUsId;
    }

    @Override
    public void setCreationUsId(Integer creationUsId) {
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
    public int getModificationUsId() {
        return modificationUsId;
    }

    @Override
    public void setModificationUsId(Integer modificationUsId) {
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
    public int getProjectId() {
        return projectId;
    }

    @Override
    public void setProjectId(Integer projectId) {
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
