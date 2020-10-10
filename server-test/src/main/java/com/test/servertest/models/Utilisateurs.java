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
}
