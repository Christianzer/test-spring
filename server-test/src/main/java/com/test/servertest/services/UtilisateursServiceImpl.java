package com.test.servertest.services;

import com.test.servertest.models.Utilisateurs;
import com.test.servertest.repository.UtilisateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UtilisateursServiceImpl implements UtilisateursService {

    @Autowired
    private UtilisateursRepository utilisateursRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public Utilisateurs saveUsers(Utilisateurs utilisateurs){
        utilisateurs.setMot_de_passe(passwordEncoder.encode(utilisateurs.getMot_de_passe()));
        return utilisateursRepository.save(utilisateurs);
    }

    @Override
    public Utilisateurs updateUsers(Utilisateurs utilisateurs){
        return utilisateursRepository.save(utilisateurs);
    }

    @Override
    public void deleteUsers(Long UtilisateursId){
        utilisateursRepository.deleteById(UtilisateursId);
    }

    @Override
    public Utilisateurs findByUsername(String username){
        return utilisateursRepository.findByUsername(username).orElse(null);
    }

    @Override
    public List<Utilisateurs> findAllUtilisateurs(){
        return utilisateursRepository.findAll();
    }

    @Override
    public Long nombreUsers(){
        return utilisateursRepository.count();
    }

}
