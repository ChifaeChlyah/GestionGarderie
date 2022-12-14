package com.ensa.gestiongarderie.repositories;

import com.ensa.gestiongarderie.entities.Activite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface ActiviteRepository extends JpaRepository<Activite,Long> {
 public Activite findByNom(String nom);
}
