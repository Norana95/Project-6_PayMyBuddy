package com.Openclassrooms.PayMyBuddy.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String firstName;
    public String lastName;
    public String username;
    public String password;
    @OneToOne
    public Solde solde;
    @OneToMany
    public List<Transaction> transactions = new ArrayList<>();

    public User(String firstname, String lastname, String email, String password, Solde solde, List<Transaction> transaction) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.username = email;
        this.password = password;
        this.solde = solde;
        this.transactions = transaction;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Solde getSolde() {
        return solde;
    }

    public void setSolde(Solde solde) {
        this.solde = solde;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}