package com.ensa.gestiongarderie.repositories;

import com.ensa.gestiongarderie.entities.EnfantHyperactif;
import com.ensa.gestiongarderie.entities.EnfantSurdoue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnfantHyperactifRepository extends JpaRepository<EnfantHyperactif,Long> {
}
