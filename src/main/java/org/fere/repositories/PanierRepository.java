package org.fere.repositories;

import org.fere.entities.PanierVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierRepository extends JpaRepository<PanierVente, Long> {
}
