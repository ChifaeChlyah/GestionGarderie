package com.ensa.gestiongarderie.repositories;

import com.ensa.gestiongarderie.entities.AideEducateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface AideEducateurRepository extends JpaRepository<AideEducateur, Long> {
}
