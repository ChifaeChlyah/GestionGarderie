package com.ensa.gestiongarderie.controller;

import com.ensa.gestiongarderie.angularClasses.Enfant_type;
import com.ensa.gestiongarderie.entities.*;
import com.ensa.gestiongarderie.enums.TypeEnfant;
import com.ensa.gestiongarderie.factory_service.EnfantFactory;
import com.ensa.gestiongarderie.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin("*")
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
    @Autowired
    NiveauRepository niveauRepository;
    @GetMapping()
    public List<Enfant_type> allEnfant()
    {
        List<Enfant> enfants=  enfantRepository.findAll();
        List<Enfant_type> enfants_Type=  new ArrayList<>();
        for (Enfant enfant : enfants) {
            Enfant_type enfant_type=new Enfant_type();
            enfant_type.enfantToEnfant_type(enfant);
            enfant_type.setType(enfantFactory.getTypeEnfant(enfant).toString());
            enfants_Type.add(enfant_type);
        }
        return enfants_Type;
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
        if(enf.getAge()<=4)
            enf.setNiveau(niveauRepository.findByNom("Niveau 1"));
        else if(enf.getAge()>4&&enf.getAge()<=8)
            enf.setNiveau(niveauRepository.findByNom("Niveau 2"));
        else
            enf.setNiveau(niveauRepository.findByNom("Niveau 3"));
        switch (type)
        {
            case ENFANT_AUTISTE:
            {
                enfantRepository.save(enf);
                enfantAutisteRepository.save(enf.convertToAutiste());
                break;
            }
            case ENFANT_SURDOUE:
            {
                enfantRepository.save(enf);
                enfantSurdoueRepository.save(enf.convertToSurdoue());
                break;
            }
            case ENFANT_HYPERACTIF:
            {
                enfantRepository.save(enf);
                enfantHyperactifRepository.save(enf.convertToHyperactif());
                break;
            }
            case ENFANT_AUTISTE_ET_HYPERACTIF:
            {
                Enfant enfant1=enfantRepository.save(enf);
                if(!enfantHyperactifRepository.findById(enfant1.getId()).isPresent())
                    enfantHyperactifRepository.save(enfant1.convertToHyperactif());
                if(!enfantAutisteRepository.findById(enfant1.getId()).isPresent())
                    enfantAutisteRepository.save(enfant1.convertToAutiste());
                break;
            }
            case ENFANT_HYPERACTIF_ET_SURDOUE:
            case ENFANT_AUTISTE_ET_SURDOUE: {
                Enfant enfant1=enfantRepository.save(enf);
                enfantRepository.save_surdoue_by_id(enfant1.getId());
                break;
            }
            case ENFANT_AUTIST_ET_HYPERACTIF_ET_SURDOUE:
            {
                Enfant enfant1=enfantRepository.save(enf);
                enfantRepository.save_hyperactif_by_id(enfant1.getId());
                enfantRepository.save_surdoue_by_id(enfant1.getId());
                break;
            }
            default: {
                enfantRepository.save(enf);
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
