package org.fere.services;

import org.fere.entities.Produit;
import org.fere.entities.Vente;
import org.fere.repositories.ProduitRepository;
import org.fere.repositories.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenteService {

    @Autowired
    private VenteRepository venteRepository;
    public List<Vente> find(){
        return venteRepository.findAll();
    }

    public Vente save(Vente produit){
        return venteRepository.save(produit);
    }

    public void deleteById(Long id) {
        venteRepository.deleteById(id);
    }
    public Vente findById(Long id) {
        return   venteRepository.findById(id).orElse(null);
    }
    public Vente update(Vente produit) {
            return venteRepository.save(produit);
    }
}
