package com.test.servertest.repository;

import com.test.servertest.models.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateursRepository extends JpaRepository<Utilisateurs,Long> {

    //recherche par nom utilisateur
    Optional<Utilisateurs> findByUsername(String username);
}
