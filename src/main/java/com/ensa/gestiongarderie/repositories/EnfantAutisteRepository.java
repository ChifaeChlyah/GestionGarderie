package com.ensa.gestiongarderie.repositories;

import com.ensa.gestiongarderie.entities.EnfantAutiste;
import com.ensa.gestiongarderie.entities.EnfantSurdoue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnfantAutisteRepository extends JpaRepository<EnfantAutiste,Long> {
}
