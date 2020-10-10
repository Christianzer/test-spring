package com.test.servertest.models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "Utilisateurs")
public class Utilisateurs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "username")
    private String username;

    @Column(name = "mot_de_passe")
    private String mot_de_passe;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Roles role;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
