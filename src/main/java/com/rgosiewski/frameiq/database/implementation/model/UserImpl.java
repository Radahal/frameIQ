package com.rgosiewski.frameiq.database.implementation.model;

import com.rgosiewski.frameiq.database.definition.model.IUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "users")
public class UserImpl extends ModelImpl implements IUser {

    @Id
    @Column(name = "id")
    private int id = -1;

    @Column
    private int usIdInserted;

    @Column
    private Date dateInserted;

    @Column
    private int usIdModified;

    @Column
    private Date dateModified;

    @Column
    private String name;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
