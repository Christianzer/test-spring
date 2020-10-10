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

}
