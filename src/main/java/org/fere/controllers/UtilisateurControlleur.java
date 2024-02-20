package org.fere.controllers;

import org.fere.entities.Utilisateur;
import org.fere.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UtilisateurControlleur {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllUsers() {
        return new ResponseEntity<>(utilisateurService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody Utilisateur utilisateur) {
        Utilisateur savedUtilisateur = utilisateurService.save(utilisateur);
        if (savedUtilisateur != null) {
            return new ResponseEntity<>(savedUtilisateur, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Utilisateur non sauvegardé", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody Utilisateur utilisateur) {
        Utilisateur updatedUtilisateur = utilisateurService.update(utilisateur);
        if (updatedUtilisateur != null) {
            return new ResponseEntity<>(updatedUtilisateur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Utilisateur non trouvé", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        utilisateurService.delete(id);
        return new ResponseEntity<>("Utilisateur supprimé avec succès", HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurService.findById(id);
        if (utilisateur != null) {
            return new ResponseEntity<>(utilisateur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Utilisateur non trouvé", HttpStatus.NOT_FOUND);
        }
    }
}