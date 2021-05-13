package com.example.laborator11.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USERS", schema = "CARINA")
public class UserEntity implements Serializable {
    private long idUser;
    private String name;

    @Id
    @Column(name = "ID_USER")
    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
