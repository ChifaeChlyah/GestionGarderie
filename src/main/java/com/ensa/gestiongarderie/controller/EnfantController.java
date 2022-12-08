package com.ensa.gestiongarderie.controller;

import com.ensa.gestiongarderie.entities.*;
import com.ensa.gestiongarderie.enums.TypeEnfant;
import com.ensa.gestiongarderie.factory_service.EnfantFactory;
import com.ensa.gestiongarderie.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="/enfant")
@RestController
public class EnfantController {
    @Autowired
    EnfantRepository enfantRepository;

    @Autowired
    EnfantAutisteRepository enfantAutisteRepository;
    @Autowired
    EnfantSurdoueRepository enfantSurdoueRepository;
    @Autowired
    EnfantHyperactifRepository enfantHyperactifRepository;

    @Autowired
    EnfantFactory enfantFactory;
    @GetMapping()
    public List<Enfant> allEnfant()
    {
        return enfantRepository.findAll();
    }


    @GetMapping(path="/parent/{id}")
    public Parent enfant(@PathVariable("id") Long idEnfant)
    {
        return enfantRepository.findById(idEnfant).get().getParent();
    }


    @GetMapping(path="/{id}")
    public Enfant getparent(@PathVariable("id")Long id )
    {
        return enfantRepository.findById(id).get();
    }

    @PostMapping("/{type}")
    public boolean addEnfant(@RequestBody Enfant enf,@PathVariable(name = "type") TypeEnfant type )
    {
        Enfant enfant=enfantFactory.getEnfant(enf);
        switch (type)
        {

            case ENFANT_AUTISTE:
            {
                enfantAutisteRepository.save((EnfantAutiste) enfant);
                break;
            }
            case ENFANT_SURDOUE:
            {
                enfantSurdoueRepository.save((EnfantSurdoue) enfant);
                break;
            }
            case ENFANT_HYPERACTIF:
            {
                enfantHyperactifRepository.save((EnfantHyperactif) enfant);
                break;
            }
            case ENFANT_AUTISTE_ET_HYPERACTIF:
            {
                Enfant enfant1=enfantRepository.save(enfant);
                if(!enfantHyperactifRepository.findById(enfant1.getId()).isPresent())
                    enfantRepository.save_hyperactif_by_id(enfant1.getId());
                break;
            }
            case ENFANT_HYPERACTIF_ET_SURDOUE:
            case ENFANT_AUTISTE_ET_SURDOUE: {
                Enfant enfant1=enfantRepository.save(enfant);
                enfantRepository.save_surdoue_by_id(enfant1.getId());
                break;
            }
            case ENFANT_AUTIST_ET_HYPERACTIF_ET_SURDOUE:
            {
                Enfant enfant1=enfantRepository.save(enfant);
                enfantRepository.save_hyperactif_by_id(enfant1.getId());
                enfantRepository.save_surdoue_by_id(enfant1.getId());
                break;
            }
            default: {
                enfantRepository.save(enfant);
            }
        }
        return true;
    }

    @DeleteMapping(path="/{id}")
    public void deleteEnfant(@PathVariable("id") long id){
       enfantRepository.deleteById(id);
    }

    @PutMapping()
    public Enfant updateParent(@RequestBody Enfant e)
    {
        return enfantRepository.save(e);
    }

}
