package com.ensa.gestiongarderie.repositories;

import com.ensa.gestiongarderie.entities.EnfantAutiste;
import com.ensa.gestiongarderie.entities.EnfantSurdoue;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EnfantAutisteRepository extends JpaRepository<EnfantAutiste,Long> {
    @Query(value = "INSERT INTO enfant_autiste(id) values(?1)",nativeQuery = true)
    @Transactional
    @Modifying
    void save_autist_by_id(long id);

    @Query(value = "SELECT count(*) FROM enfant_autiste where id=?1",nativeQuery = true)
    int existsById(long id);
}
