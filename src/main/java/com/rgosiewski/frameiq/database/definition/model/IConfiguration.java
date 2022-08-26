package com.rgosiewski.frameiq.database.definition.model;

public interface IConfiguration extends IModel {

    long getProjectId();

    void setProjectId(Long projectId);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    String getTag();

    void setTag(String tag);

    String getInputFileName();

    void setInputFileName(String inputFileName);

    String getAlgorithm();

    void setAlgorithm(String algorithm);

    String getAlgorithmProperties();

    void setAlgorithmProperties(String algorithmProperties);

    String getStrategy();

    void setStrategy(String strategy);
}
