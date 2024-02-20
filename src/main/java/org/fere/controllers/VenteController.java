package org.fere.controllers;

import org.fere.entities.PanierVente;
import org.fere.entities.Vente;
import org.fere.services.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventes")
public class VenteController {

    @Autowired
    private VenteService venteService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Vente>> findAllPaniers() {
        List<Vente> paniers = venteService.find();
        return new ResponseEntity<>(paniers, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Vente> savePanier(@RequestBody Vente panierVente) {
        Vente savedPanier = venteService.save(panierVente);
        return new ResponseEntity<>(savedPanier, HttpStatus.CREATED);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Vente> findPanierById(@PathVariable Long id) {
        Vente vente = venteService.findById(id);
        return new ResponseEntity<>(vente, HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deletePanierById(@PathVariable Long id) {
            venteService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Vente> updatePanier(@RequestBody Vente vente) {
        venteService.update(vente);
        return new ResponseEntity<>(vente, HttpStatus.OK);
    }
}

