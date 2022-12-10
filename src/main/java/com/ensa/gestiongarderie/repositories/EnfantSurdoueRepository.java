package com.ensa.gestiongarderie.repositories;

import com.ensa.gestiongarderie.entities.EnfantSurdoue;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EnfantSurdoueRepository extends JpaRepository<EnfantSurdoue,Long> {
    @Query(value = "INSERT INTO enfant_surdoue(quotient_intellectuel,id) values(150,?1)",nativeQuery = true)
    @Transactional
    @Modifying
    void save_surdoue_by_id(long id);

    @Query(value = "SELECT count(*) FROM enfant_surdoue where id=?1",nativeQuery = true)
    int existsById(long id);
}
