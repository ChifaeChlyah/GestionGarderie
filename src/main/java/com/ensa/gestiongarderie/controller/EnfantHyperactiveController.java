package com.ensa.gestiongarderie.controller;

import com.ensa.gestiongarderie.entities.Activite;
import com.ensa.gestiongarderie.entities.Enfant;
import com.ensa.gestiongarderie.entities.EnfantHyperactif;
import com.ensa.gestiongarderie.repositories.EnfantHyperactifRepository;
import com.ensa.gestiongarderie.repositories.EnfantHyperactifRepository;
import com.ensa.gestiongarderie.repositories.EnfantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/enfantHyperactive")
public class EnfantHyperactiveController {


    @Autowired
    EnfantHyperactifRepository enfantHyperactifRepository ;

    @Autowired
    EnfantRepository enfantRepository;



    @GetMapping()
    public List<EnfantHyperactif> getAll(){
        return enfantHyperactifRepository.findAll();
    }



    @PutMapping ("/{id}/addActivite")
    public void addActiviteToEnfant(@RequestBody Activite activite, @PathVariable(name = "id") long id){
        EnfantHyperactif enfantAutiste = enfantHyperactifRepository.findById(id).get();
        Collection<Activite> activites = enfantAutiste.getActivitesSpeciales_hyperactifs();
        activites.add(activite);
        enfantAutiste.setActivitesSpeciales_hyperactifs(activites);
    }

    @PutMapping ("/{id}/allActivite")
    public Collection<Activite> allActiviteEnfant(@RequestBody Activite activite, @PathVariable(name = "id") long id){
        Collection<Activite> activites = enfantRepository.findById(id).get().getNiveau().getActivites();
        for (Activite activite1 :  enfantHyperactifRepository.findById(id).get().getActivitesSpeciales_hyperactifs()) {
            activites.add(activite1);
        }
        return activites.stream().toList();
    }



    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        enfantRepository.deleteById(id);
    }

}
