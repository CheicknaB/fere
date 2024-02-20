package org.fere.services;

import org.fere.entities.Utilisateur;
import org.fere.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;


    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur save(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur update(Utilisateur utilisateur) {
        if (utilisateur.getUtilisateurId() != null && utilisateurRepository.existsById(utilisateur.getUtilisateurId())) {
            return utilisateurRepository.save(utilisateur);
        } else {
            return null; // Ou lancez une exception appropriée pour indiquer que l'utilisateur n'existe pas
        }
    }

    public void delete(Long id) {
        utilisateurRepository.deleteById(id);
    }

    public Utilisateur findById(Long id) {
        return utilisateurRepository.findById(id).orElse(null);
    }

}
