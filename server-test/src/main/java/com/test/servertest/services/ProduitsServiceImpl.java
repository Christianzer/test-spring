package com.test.servertest.services;

import com.test.servertest.models.Produits;
import com.test.servertest.repository.ProduitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProduitsServiceImpl implements ProduitsService{

    @Autowired
    private ProduitsRepository produitsRepository;

    @Override
    public Produits saveProduits(final Produits produits){
        produitsRepository.save(produits);
        return produits;
    }

    @Override
    public Produits updateProduits(final Produits produits){
        return produitsRepository.save(produits);
    }

    @Override
    public void deleteProduits(final Long ProduitsId){
        produitsRepository.deleteById(ProduitsId);
    }

    @Override
    public List<Produits> findAllProduits(){
        return produitsRepository.findAll();
    }

    @Override
    public Long nombreProduits(){
        return produitsRepository.count();
    }

}
