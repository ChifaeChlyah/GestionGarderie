package com.ensa.gestiongarderie.controller;

import com.ensa.gestiongarderie.entities.Enfant;
import com.ensa.gestiongarderie.entities.Parent;
import com.ensa.gestiongarderie.repositories.EnfantRepository;
import com.ensa.gestiongarderie.repositories.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="/enfant")
@RestController
public class EnfantController {
    @Autowired
    EnfantRepository enfantRepository;



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

    @PostMapping()
    public boolean addEnfant(@RequestBody Enfant enf)
    {
        if(enfantRepository.findById(enf.getId()).isPresent())
            return false;
        enfantRepository.save(enf);
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
