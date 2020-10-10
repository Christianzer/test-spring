package com.test.servertest.services;

import com.test.servertest.models.Produits;

import java.util.List;

public interface ProduitsService {
    Produits saveProduits(Produits produits);

    Produits updateProduits(Produits produits);

    void deleteProduits(Long ProduitsId);

    List<Produits> findAllProduits();

    Long nombreProduits();
}
