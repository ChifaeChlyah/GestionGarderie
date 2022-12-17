package com.ensa.gestiongarderie.controller;


import com.ensa.gestiongarderie.entities.Administrateur;
import com.ensa.gestiongarderie.entities.Enfant;
import com.ensa.gestiongarderie.entities.IEnfant;
import com.ensa.gestiongarderie.entities.Parent;
import com.ensa.gestiongarderie.factory_service.EnfantFactory;
import com.ensa.gestiongarderie.mapping.Connection;
import com.ensa.gestiongarderie.repositories.EnfantRepository;
import com.ensa.gestiongarderie.repositories.NiveauRepository;
import com.ensa.gestiongarderie.repositories.ParentRepository;
import com.ensa.gestiongarderie.services.PaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/parent")
public class ParentContoller {
    @Autowired
    EnfantFactory enfantFactory;
    @Autowired
    NiveauRepository niveauRepository;
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
        Enfant enfant=parent.getEnfant();
        if(enfant.getAge()<4)
            enfant.setNiveau(niveauRepository.findByNom("Niveau 1"));
        else if(enfant.getAge()>4&&enfant.getAge()<9)
            enfant.setNiveau(niveauRepository.findByNom("Niveau 2"));
        else
            enfant.setNiveau(niveauRepository.findByNom("Niveau 3"));
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
        IEnfant enfant=enfantFactory.getEnfant(parent.getEnfant());
        double prix=enfant.cout();
        if(paymentStrategy.payer(prix))
            parent.setStatutPayement(true);
    }
    @PostMapping("/connection")
    public boolean verifierCompte(@RequestBody Connection connection){
        Parent a=parentRepository.findByEmail(connection.getEmail());
        if(a!=null){
            if(a.getMotDePasse().equals(connection.getPassword())){
                return  true;
            }
        }
        return  false ;
    }
//@Autowired
//    EnfantRepository enfantRepository;
//    @GetMapping(path="/payer/{id}")
//    public void payer(@PathVariable("id")Long idParent)
//    {
//        IEnfant enfant=enfantRepository.findById(idParent).get();
//        enfant=enfantFactory.getEnfant((Enfant) enfant);
//        System.out.println(enfant.cout());
//    }
}
