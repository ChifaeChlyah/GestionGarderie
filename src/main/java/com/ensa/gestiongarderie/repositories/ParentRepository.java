package com.ensa.gestiongarderie.repositories;

import com.ensa.gestiongarderie.entities.Administrateur;
import com.ensa.gestiongarderie.entities.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface ParentRepository extends JpaRepository<Parent,Long> {
    public Parent findByEmail(String email);
}
