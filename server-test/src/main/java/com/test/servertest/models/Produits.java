package com.test.servertest.models;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "Produits")
public class Produits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prix")
    private Double prix;

    @Column(name = "Description")
    private String description;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
