package com.rgosiewski.frameiq.database.definition.model;

public interface PasswordImpl extends IModel {

    String getSalt();

    void setSalt(String salt);

    String getHash();

    void setHash(String hash);
}
