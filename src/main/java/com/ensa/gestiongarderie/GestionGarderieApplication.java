package com.ensa.gestiongarderie;

import com.ensa.gestiongarderie.entities.Administrateur;
import com.ensa.gestiongarderie.repositories.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionGarderieApplication implements CommandLineRunner {
    @Autowired
    AdministrateurRepository administrateurRepository;
    public static void main(String[] args) {
        SpringApplication.run(GestionGarderieApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        if(administrateurRepository.findByEmail("admin@gmail.com")==null)
            administrateurRepository.save(new Administrateur("admin","admin","admin@gmail.com","123"));
    }
}
