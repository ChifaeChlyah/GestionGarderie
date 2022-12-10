package com.ensa.gestiongarderie.repositories;

import com.ensa.gestiongarderie.entities.EnfantHyperactif;
import com.ensa.gestiongarderie.entities.EnfantSurdoue;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EnfantHyperactifRepository extends JpaRepository<EnfantHyperactif,Long> {
    @Query(value = "SELECT count(*) FROM enfant_hyperactif where id=?1",nativeQuery = true)
    int existsById(long id);
}
