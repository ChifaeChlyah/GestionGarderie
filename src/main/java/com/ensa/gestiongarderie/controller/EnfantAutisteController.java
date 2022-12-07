package com.ensa.gestiongarderie.controller;

<<<<<<< HEAD
=======
import com.ensa.gestiongarderie.entities.Activite;
>>>>>>> e8f0fa87f3775430134f8e2afc5b93ef5e19af05
import com.ensa.gestiongarderie.entities.Enfant;
import com.ensa.gestiongarderie.entities.EnfantAutiste;
import com.ensa.gestiongarderie.repositories.EnfantAutisteRepository;
import com.ensa.gestiongarderie.repositories.EnfantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/enfantAutiste")
public class EnfantAutisteController {

    @Autowired
    EnfantAutisteRepository enfantAutisteRepository;

    @Autowired
    EnfantRepository enfantRepository;
<<<<<<< HEAD
=======


>>>>>>> e8f0fa87f3775430134f8e2afc5b93ef5e19af05

    @GetMapping()
    public List<EnfantAutiste> getAll(){
        return enfantAutisteRepository.findAll();
    }

    @PostMapping
<<<<<<< HEAD
    public void createEtuAutiste(@RequestBody Enfant enfantAutiste){
        enfantRepository.save(enfantAutiste);
    }

=======
    public void createEtuAutiste(@RequestBody EnfantAutiste enfantAutiste){
        enfantAutiste.setEnfant((Enfant) enfantAutiste);
        enfantAutisteRepository.save(enfantAutiste);
    }

    @PutMapping ("/{id}/addActivite")
public void addActiviteToEnfant(@RequestBody Activite activite, @PathVariable(name = "id") long id){
        EnfantAutiste enfantAutiste = enfantAutisteRepository.findById(id).get();
        Collection<Activite> activites = enfantAutiste.getActivitesSpeciales_autisme();
        activites.add(activite);
        enfantAutiste.setActivitesSpeciales_autisme(activites);
    }

    @PutMapping ("/{id}/allActivite")
    public Collection<Activite> allActiviteEnfant(@RequestBody Activite activite, @PathVariable(name = "id") long id){
        Collection<Activite> activites = enfantAutisteRepository.findById(id).get().getNiveau().getActivites();
        for (Activite activite1 :  enfantAutisteRepository.findById(id).get().getActivitesSpeciales_autisme()) {
            activites.add(activite1);
        }
        return activites.stream().toList();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        enfantRepository.deleteById(id);
    }


>>>>>>> e8f0fa87f3775430134f8e2afc5b93ef5e19af05
}

