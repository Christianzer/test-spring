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
}
