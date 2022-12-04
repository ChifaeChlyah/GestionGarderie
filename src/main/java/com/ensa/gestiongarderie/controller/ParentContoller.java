package com.ensa.gestiongarderie.controller;


import com.ensa.gestiongarderie.entities.Enfant;
import com.ensa.gestiongarderie.entities.Parent;
import com.ensa.gestiongarderie.repositories.ParentRepository;
import com.ensa.gestiongarderie.services.PaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/parent")
public class ParentContoller {

    @Autowired
    ParentRepository parentRepository;
    @GetMapping()
    public List<Parent> tousLesParents()
    {
        return parentRepository.findAll();
    }
    @GetMapping(path="/enfantByParentId/{id}")
    public Enfant enfant(@PathVariable("id") Long idParent)
    {
        return parentRepository.findById(idParent).get().getEnfant();
    }
    @GetMapping(path="/{id}")
    public Parent getparent(@PathVariable("id")Long idParent)
    {
        return parentRepository.findById(idParent).get();
    }

    @PostMapping()
    public boolean addParent(@RequestBody Parent parent)
    {
        if(parentRepository.findById(parent.getId()).isPresent())
            return false;
        parentRepository.save(parent);
        return true;
    }

    @PutMapping()
    public Parent updateParent(@RequestBody Parent parent)
    {
        return parentRepository.save(parent);
    }
    @DeleteMapping("/{id}")
    public void deleteParent(@PathVariable Long id) {
        parentRepository.delete(parentRepository.findById(id).get());
    }


    @PostMapping(path="payer/{id}")
    public void payer(@PathVariable("id")Long idParent, PaymentStrategy paymentStrategy)
    {
        Parent parent=parentRepository.findById(idParent).get();
        double prix=parent.getEnfant().getNiveau().getPrix();
        if(paymentStrategy.payer(prix))
            parent.setStatutPayement(true);
    }
}
