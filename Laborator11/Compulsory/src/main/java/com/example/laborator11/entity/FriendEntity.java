package com.example.laborator11.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FRIENDS", schema = "CARINA")
public class FriendEntity implements Serializable {
    private Long id;
    private Long idUser;
    private Long idFriend;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ID_USER")
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "ID_FRIEND")
    public Long getIdFriend() {
        return idFriend;
    }

    public void setIdFriend(Long idFriend) {
        this.idFriend = idFriend;
    }


}
