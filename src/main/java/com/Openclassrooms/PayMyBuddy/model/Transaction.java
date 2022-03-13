package com.Openclassrooms.PayMyBuddy.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public int amount;

    @ManyToOne(cascade = {CascadeType.ALL})
    //plusieurs transactions pour un utilisateur
    public User sender = new User();
    @ManyToOne(cascade = {CascadeType.ALL})
    public User receiver = new User();

    public Transaction(int amount, User sender, User receiver) {
        this.amount = amount;
        this.sender = sender;
        this.receiver = receiver;
    }

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
}
