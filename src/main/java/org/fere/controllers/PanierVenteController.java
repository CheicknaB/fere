package org.fere.controllers;

import org.fere.entities.PanierVente;
import org.fere.services.PanierVenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paniers")
public class PanierVenteController {

    @Autowired
    private PanierVenteService panierVenteService;

    @GetMapping("/findAll")
    public ResponseEntity<List<PanierVente>> findAllPaniers() {
        List<PanierVente> paniers = panierVenteService.findAll();
        return new ResponseEntity<>(paniers, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<PanierVente> savePanier(@RequestBody PanierVente panierVente) {
        PanierVente savedPanier = panierVenteService.save(panierVente);
        return new ResponseEntity<>(savedPanier, HttpStatus.CREATED);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<PanierVente> findPanierById(@PathVariable Long id) {
        PanierVente panierVente = panierVenteService.findById(id);
        return new ResponseEntity<>(panierVente, HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deletePanierById(@PathVariable Long id) {
            panierVenteService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<PanierVente> updatePanier(@RequestBody PanierVente panierVente) {
        panierVenteService.update(panierVente);
        return new ResponseEntity<>(panierVente, HttpStatus.OK);
    }
}

