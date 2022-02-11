package com.Openclassrooms.PayMyBuddy.model;

import javax.persistence.*;

@Entity
@Table
public class Solde {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public int somme;

    public int getSoldeActuel() {
        return somme;
    }

    public void setSoldeActuel(int soldeActuel) {
        this.somme = soldeActuel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
