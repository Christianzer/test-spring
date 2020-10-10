package com.test.servertest.repository;

import com.test.servertest.models.Produits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitsRepository extends JpaRepository<Produits,Long> {
}
