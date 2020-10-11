package com.test.servertest.controllers;

import com.test.servertest.models.Produits;
import com.test.servertest.models.StringResponse;
import com.test.servertest.models.Utilisateurs;
import com.test.servertest.services.ProduitsService;
import com.test.servertest.services.TransactionsService;
import com.test.servertest.services.UtilisateursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdministrateursController {
    @Autowired
    private UtilisateursService utilisateursService;

    @Autowired
    private ProduitsService produitsService;

    @Autowired
    private TransactionsService transactionsService;

    @PutMapping("/api/admin/utilisateurs-update")
    public ResponseEntity<?> updateUser(@RequestBody Utilisateurs utilisateurs) {
        Utilisateurs existUser = utilisateursService.findByUsername(utilisateurs.getUsername());
        if (existUser != null && !existUser.getId().equals(utilisateurs.getId())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(utilisateursService.updateUsers(utilisateurs), HttpStatus.CREATED);
    }

    //This can be also @DeleteMapping.
    @PostMapping("/api/admin/user-delete")
    public ResponseEntity<?> deleteUser(@RequestBody Utilisateurs utilisateurs){
        utilisateursService.deleteUsers(utilisateurs.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/admin/user-all")
    public ResponseEntity<?> findAllUsers() {
        return new ResponseEntity<>(utilisateursService.findAllUtilisateurs(), HttpStatus.OK);
    }

    @GetMapping("/api/admin/user-number")
    public ResponseEntity<?> nombreOfUsers(){
        Long number = utilisateursService.nombreUsers();
        StringResponse response = new StringResponse();
        response.setResponse(number.toString());
        //to return it, we will use String Response because long is not a suitable response for rest api
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/api/admin/product-create")
    public ResponseEntity<?> createProduct(@RequestBody Produits produits){
        return new ResponseEntity<>(produitsService.saveProduits(produits), HttpStatus.CREATED);
    }

    @PutMapping("/api/admin/product-update")
    public ResponseEntity<?> updateProduct(@RequestBody Produits produits){
        return new ResponseEntity<>(produitsService.updateProduits(produits), HttpStatus.CREATED);
    }

    //This can be also @DeleteMapping.
    @PostMapping("/api/admin/product-delete")
    public ResponseEntity<?> deleteProduct(@RequestBody Produits produits){
        produitsService.deleteProduits(produits.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/admin/product-all")
    public ResponseEntity<?> findAllProducts(){
        return new ResponseEntity<>(produitsService.findAllProduits(), HttpStatus.OK);
    }

    @GetMapping("/api/admin/product-number")
    public ResponseEntity<?> numberOfProducts(){
        Long number = produitsService.nombreProduits();
        StringResponse response = new StringResponse();
        response.setResponse(number.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/api/admin/transaction-all")
    public ResponseEntity<?> findAllTransactions(){
        return new ResponseEntity<>(transactionsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("api/admin/transaction-number")
    public ResponseEntity<?> numberOfTransactions(){
        Long number = transactionsService.nombreTransactions();
        StringResponse response = new StringResponse();
        response.setResponse(number.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
