package com.rgosiewski.frameiq.database.definition.model;

public interface IConfiguration extends IModel {

    int getId();

    void setId(int id);

    int getProjectId();

    void setProjectId(int projectId);

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
