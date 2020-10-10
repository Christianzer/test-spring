package com.test.servertest.controllers;

import com.test.servertest.models.Roles;
import com.test.servertest.models.Transactions;
import com.test.servertest.models.Utilisateurs;
import com.test.servertest.services.ProduitsService;
import com.test.servertest.services.TransactionsService;
import com.test.servertest.services.UtilisateursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.LocalDateTime;

@RestController
public class UtilisateursController {

    @Autowired
    private UtilisateursService utilisateursService;

    @Autowired
    private ProduitsService produitsService;

    @Autowired
    private TransactionsService transactionsService;

    @PostMapping("/api/utilisateurs/inscription")
    public ResponseEntity<?> register (@RequestBody Utilisateurs utilisateurs){
        if (utilisateursService.findByUsername(utilisateurs.getUsername()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        utilisateurs.setRole(Roles.UTILISATEURS);
        return  new ResponseEntity<>(utilisateursService.saveUsers(utilisateurs),HttpStatus.CREATED);
    }

    @GetMapping("/api/utilisateurs/connexion")
    public ResponseEntity<?> getUtilisateurs(Principal principal){
        if (principal == null || principal.getName() == null){
            return ResponseEntity.ok(principal);
        }
        return new ResponseEntity<>(utilisateursService.findByUsername(principal.getName()),HttpStatus.OK);
    }

    @PostMapping("/api/utilisateurs/push")
    public ResponseEntity<?> pushProduits(@RequestBody Transactions transactions){
        transactions.setDate_push(LocalDateTime.now());
        return new ResponseEntity<>(transactionsService.saveTransactions(transactions),HttpStatus.CREATED);
    }

    @GetMapping("/api/utilisateurs/produits")
    public ResponseEntity<?> getAllProduits(){
        return new ResponseEntity<>(produitsService.findAllProduits(),HttpStatus.OK);
    }
}
