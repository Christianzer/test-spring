package com.test.servertest.models;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "produit_id",referencedColumnName = "id")
    private Produits produits;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id",referencedColumnName = "id")
    private Utilisateurs utilisateurs;

    @Column(name = "date_push")
    private LocalDateTime date_push;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Produits getProduits() {
        return produits;
    }

    public void setProduits(Produits produits) {
        this.produits = produits;
    }

    public Utilisateurs getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Utilisateurs utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public LocalDateTime getDate_push() {
        return date_push;
    }

    public void setDate_push(LocalDateTime date_push) {
        this.date_push = date_push;
    }
}
