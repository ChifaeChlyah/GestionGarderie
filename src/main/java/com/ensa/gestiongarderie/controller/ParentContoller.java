package com.ensa.gestiongarderie.controller;


import com.ensa.gestiongarderie.angularClasses.DonnessPayment;
import com.ensa.gestiongarderie.angularClasses.Enfant_type;
import com.ensa.gestiongarderie.entities.Administrateur;
import com.ensa.gestiongarderie.entities.Enfant;
import com.ensa.gestiongarderie.entities.IEnfant;
import com.ensa.gestiongarderie.entities.Parent;
import com.ensa.gestiongarderie.factory_service.EnfantFactory;
import com.ensa.gestiongarderie.factory_service.PayementStrategyFactory;
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
    @Autowired
    EnfantRepository enfantRepository;
    @Autowired
    PayementStrategyFactory payementStrategyFactory;

    @GetMapping()
    public List<Parent> tousLesParents()
    {
        return parentRepository.findAll();
    }
    @GetMapping(path="/enfantByParentId/{id}")
    public Enfant_type enfant(@PathVariable("id") Long idParent)
    {
        Enfant enfant=null;
        for (Enfant e : enfantRepository.findAll()) {
            if(e!=null&&e.getParent()!=null&&e.getParent().getId()==idParent)
                enfant=e;
        }
        if (enfant==null)
            return null;
        Enfant_type enfant_type=new Enfant_type();
        enfant_type.enfantToEnfant_type(enfant);
        enfant_type.setType(enfantFactory.getTypeEnfant(enfant).toString());
        return enfant_type;
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


    @PostMapping(path="payer/{id}/{payementStrategy}")
    public void payer(@PathVariable("id")Long idParent,@PathVariable("payementStrategy") String strategy,@RequestBody DonnessPayment donnessPayment)
    {
        PaymentStrategy paymentStrategy=payementStrategyFactory.getStrategy(strategy,donnessPayment);

        Parent parent=parentRepository.findById(idParent).get();
        IEnfant enfant=enfantFactory.getEnfant(parent.getEnfant());
        double prix=enfant.cout();
        if(paymentStrategy.payer(prix)) {
            parent.setStatutPayement(true);
            parentRepository.save(parent);
        }
    }
    @PostMapping("/connection")
    public Long verifierCompte(@RequestBody Connection connection){
        Parent a=parentRepository.findByEmail(connection.getEmail());
        if(a!=null){
            if(a.getMotDePasse().equals(connection.getPassword())){
                return  a.getId();
            }
        }
        return  null ;
    }

}
