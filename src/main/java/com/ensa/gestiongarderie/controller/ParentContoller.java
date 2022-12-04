package com.ensa.gestiongarderie.controller;


import com.ensa.gestiongarderie.entities.Enfant;
import com.ensa.gestiongarderie.entities.Parent;
import com.ensa.gestiongarderie.repositories.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parent")
public class ParentContoller {

    @Autowired
    ParentRepository parentRepository;
    @GetMapping(path="/tousLesParents")
    public List<Parent> tousLesParents()
    {
        return parentRepository.findAll();
    }
    @GetMapping(path="/enfant/{id}")
    public Enfant enfant(@PathVariable("id") Long idParent)
    {
        return parentRepository.findById(idParent).get().getEnfant();
    }
    @GetMapping(path="/parent/{id}")
    public Parent getparent(@PathVariable("id")Long idParent)
    {
        return parentRepository.findById(idParent).get();
    }

    @PostMapping(path="/add-parent")
    public boolean addPortfeuille(@RequestBody Parent parent)
    {
        if(parentRepository.findById(parent.getId()).isPresent())
            return false;
        parentRepository.save(parent);
        return true;
    }

    @PutMapping(path="/update-parent")
    public Parent updateParent(@RequestBody Parent parent)
    {
        return parentRepository.save(parent);
    }
}
