package com.rgosiewski.frameiq.database.definition.model;

public interface IPassword extends IModel {

    String getSalt();

    void setSalt(String salt);

    String getHash();

    void setHash(String hash);
}
