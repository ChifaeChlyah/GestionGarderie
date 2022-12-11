package com.ensa.gestiongarderie.controller;

import com.ensa.gestiongarderie.entities.Activite;
import com.ensa.gestiongarderie.entities.Enfant;
import com.ensa.gestiongarderie.entities.Niveau;
import com.ensa.gestiongarderie.entities.Parent;
import com.ensa.gestiongarderie.repositories.NiveauRepository;
import com.ensa.gestiongarderie.repositories.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/niveau")
public class NiveauController {
    @Autowired
    NiveauRepository niveauRepository;
    @GetMapping()
    public List<Niveau> tousLesNiveaux()
    {
        return niveauRepository.findAll();
    }

    @PostMapping()
    public boolean addParent(@RequestBody Niveau niveau)
    {
        if(niveauRepository.findById(niveau.getId()).isPresent())
            return false;
        niveauRepository.save(niveau);
        return true;
    }
    @GetMapping(path="enfantsByNiveauId/{id}")
    public List<Enfant> enfantsParNiveau(@PathVariable("id")Long idNiveau)
    {
        return niveauRepository.findById(idNiveau).get().getEnfants();
    }

    @GetMapping(path="activitesByNiveauId/{id}")
    public List<Activite> activitesParNiveau(@PathVariable("id")Long idNiveau)
    {
        return niveauRepository.findById(idNiveau).get().getActivites();
    }
}
