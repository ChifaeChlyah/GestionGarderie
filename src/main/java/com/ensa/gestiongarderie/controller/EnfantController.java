package com.ensa.gestiongarderie.controller;

import com.ensa.gestiongarderie.entities.Enfant;
import com.ensa.gestiongarderie.entities.Parent;
import com.ensa.gestiongarderie.repositories.EnfantRepository;
import com.ensa.gestiongarderie.repositories.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(path="/enfant")
public class EnfantController {
    @Autowired
    EnfantRepository enfantRepository;

    @PostMapping()
    public Enfant add(@RequestBody Enfant  e ){
        return  enfantRepository.save(e);
    }

//    @GetMapping
//    public List<Enfant>


}
