package com.rgosiewski.frameiq.database.definition.model;

public interface IUser extends IModel {

    String getName();

    void setName(String name);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getGender();

    void setGender(String gender);

    String getEmail();

    void setEmail(String email);

    int getPasswordId();

    void setPasswordId(int passwordId);
}
