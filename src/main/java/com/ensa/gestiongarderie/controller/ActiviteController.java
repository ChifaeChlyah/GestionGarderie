package com.ensa.gestiongarderie.controller;

import com.ensa.gestiongarderie.entities.Activite;
import com.ensa.gestiongarderie.entities.Enfant;
import com.ensa.gestiongarderie.entities.Niveau;
import com.ensa.gestiongarderie.entities.Parent;
import com.ensa.gestiongarderie.repositories.ActiviteRepository;
import com.ensa.gestiongarderie.repositories.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activite")
public class ActiviteController {
    @Autowired
    ActiviteRepository activiteRepository;
    @GetMapping()
    public List<Activite> tousLesActivites()
    {
        return activiteRepository.findAll();
    }


    @PostMapping()
    public boolean addActivite(@RequestBody Activite activite)
    {
        if(activiteRepository.findById(activite.getId()).isPresent())
            return false;
        activiteRepository.save(activite);
        return true;
    }
    @DeleteMapping("/{id}")
    public void deleteActivite(@PathVariable Long id) {
        activiteRepository.delete(activiteRepository.findById(id).get());
    }
}
