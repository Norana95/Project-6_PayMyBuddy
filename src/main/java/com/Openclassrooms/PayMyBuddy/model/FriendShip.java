package com.Openclassrooms.PayMyBuddy.model;

import javax.persistence.*;

@Table
@Entity
public class FriendShip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    public User user= new User();
    @ManyToOne
    public User friend = new User();

    public FriendShip(User user, User friend) {
        this.user = user;
        this.friend = friend;
    }

    public FriendShip() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }
}
