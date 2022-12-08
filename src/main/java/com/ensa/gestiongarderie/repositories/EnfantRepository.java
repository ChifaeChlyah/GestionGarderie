package com.ensa.gestiongarderie.repositories;


import com.ensa.gestiongarderie.entities.Enfant;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface EnfantRepository extends JpaRepository<Enfant,Long> {
    @Query(value = "INSERT INTO enfant_autiste(id) values(?1)",nativeQuery = true)
    @Transactional
    @Modifying
    void save_autist_by_id(long id);
    @Query(value = "INSERT INTO enfant_hyperactif(id) values(?1)",nativeQuery = true)
    @Transactional
    @Modifying
    void save_hyperactif_by_id(long id);
    @Query(value = "INSERT INTO enfant_surdoue(quotient_intellectuel,id) values(150,?1)",nativeQuery = true)
    @Transactional
    @Modifying
    void save_surdoue_by_id(long id);
}
