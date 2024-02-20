package org.fere.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fere.entities.Produit;
import org.fere.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;
    public List<Produit> find(){
        return produitRepository.findAll();
    }

    public Produit save(Produit produit){
        return produitRepository.save(produit);
    }

    public void deleteById(Long id) {
        produitRepository.deleteById(id);
    }
    public Produit findById(Long id) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        return optionalProduit.orElse(null);
    }
    public Produit update(Produit produit) {
            return produitRepository.save(produit);
    }
}
