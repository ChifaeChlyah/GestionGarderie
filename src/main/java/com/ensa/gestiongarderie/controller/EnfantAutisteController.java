package com.ensa.gestiongarderie.controller;

import com.ensa.gestiongarderie.entities.Enfant;
import com.ensa.gestiongarderie.entities.EnfantAutiste;
import com.ensa.gestiongarderie.repositories.EnfantAutisteRepository;
import com.ensa.gestiongarderie.repositories.EnfantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enfantAutiste")
public class EnfantAutisteController {

    @Autowired
    EnfantAutisteRepository enfantAutisteRepository;

    @Autowired
    EnfantRepository enfantRepository;



    @GetMapping()
    public List<EnfantAutiste> getAll(){
        return enfantAutisteRepository.findAll();
    }

    @PostMapping
    public void createEtuAutiste(@RequestBody EnfantAutiste enfantAutiste){
        enfantAutiste.setEnfant((Enfant) enfantAutiste);
        enfantRepository.save((Enfant) enfantAutiste);
        enfantAutisteRepository.save(enfantAutiste);
    }
}

