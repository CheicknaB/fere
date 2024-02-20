package org.fere.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PanierVente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long panierId;

    private Long utilisateurId;

    @OneToMany
    private List<Produit> produits;

    private LocalDateTime dateCreation;
    private String status;

}

