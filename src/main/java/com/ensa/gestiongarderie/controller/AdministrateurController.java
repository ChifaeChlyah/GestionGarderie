package com.ensa.gestiongarderie.controller;

import com.ensa.gestiongarderie.entities.Administrateur;
import com.ensa.gestiongarderie.repositories.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/administrateur")
public class AdministrateurController {

    @Autowired
    AdministrateurRepository administrateurRepository;


    @PostMapping()
    public boolean addEnfant(@RequestBody Administrateur ad)
    {
        if(administrateurRepository.findById(ad.getId()).isPresent())
            return false;
        administrateurRepository.save(ad);
        return true;
    }

    @PostMapping
    public boolean verifierCompte(String email,String password){
        Administrateur a=administrateurRepository.findByEmail(email);
        if(a!=null){
            if(a.getMotDePasse()==email){
                return  true;
            }
        }
      return  false ;
    }
}
