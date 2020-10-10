package com.test.servertest.services;

import com.test.servertest.models.Utilisateurs;

import java.util.List;

public interface UtilisateursService {
    Utilisateurs saveUsers(Utilisateurs utilisateurs);

    Utilisateurs updateUsers(Utilisateurs utilisateurs);

    void deleteUsers(Long UtilisateursId);

    Utilisateurs findByUsername(String username);

    List<Utilisateurs> findAllUtilisateurs();

    Long nombreUsers();
}
