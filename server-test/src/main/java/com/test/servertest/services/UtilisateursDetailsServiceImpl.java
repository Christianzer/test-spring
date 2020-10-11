package com.test.servertest.services;

import com.test.servertest.models.Utilisateurs;
import com.test.servertest.repository.UtilisateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UtilisateursDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UtilisateursRepository utilisateursRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateurs utilisateurs = utilisateursRepository.findByUsername(username).orElse(null);
        if(utilisateurs == null){
            throw new UsernameNotFoundException(username);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(utilisateurs.getRole().name()));

        return new org.springframework.security.core.userdetails.User(
                utilisateurs.getUsername(),
                utilisateurs.getMot_de_passe(),
                grantedAuthorities
        );
    }
}
