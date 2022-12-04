package com.ensa.gestiongarderie.repositories;

import com.ensa.gestiongarderie.entities.CarteDeCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface CarteDeCreditRepository extends JpaRepository<CarteDeCredit,Long> {
    public CarteDeCredit findByNumeroCarte(String numeroCarte);
}
