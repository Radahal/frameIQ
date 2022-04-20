package com.rgosiewski.frameiq.database.definition.model;

public interface IBlueprint extends IModel {

    int getConfigurationId();

    void setConfigurationId(int configurationId);

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

    String getStrategy();

    void setStrategy(String strategy);

    String getAlgorithmProperties();

    void setAlgorithmProperties(String algorithmProperties);
}
