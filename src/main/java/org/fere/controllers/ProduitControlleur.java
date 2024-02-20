package org.fere.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fere.entities.Produit;
import org.fere.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProduitControlleur {
    @Autowired
    private ProduitService produitService;

    @GetMapping("/find")
    public ResponseEntity<?> findProducts(){
        return new ResponseEntity<>(produitService.find(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Produit> findProductById(@PathVariable Long id) {
        Produit produit = produitService.findById(id);
        if (produit != null) {
            return new ResponseEntity<>(produit, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update")
    public ResponseEntity<Produit> updateProduct(@RequestBody Produit produit) {
        Produit updatedProduit = produitService.update(produit);
        if (updatedProduit != null) {
            return new ResponseEntity<>(updatedProduit, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
            produitService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/save")
    public Produit save(@RequestBody Produit produit){
        return produitService.save(produit);
    }
}
