package org.fere.services;

import org.fere.entities.PanierVente;
import org.fere.repositories.PanierVenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanierVenteService {

    @Autowired
    private PanierVenteRepository panierVenteRepository;

    public List<PanierVente> findAll() {
        return panierVenteRepository.findAll();
    }

    public PanierVente save(PanierVente panierVente) {
        return panierVenteRepository.save(panierVente);
    }

    public PanierVente findById(Long id) {
        return panierVenteRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        panierVenteRepository.deleteById(id);
    }

    public void update(PanierVente panierVente) {
        panierVenteRepository.save(panierVente);
    }
}

