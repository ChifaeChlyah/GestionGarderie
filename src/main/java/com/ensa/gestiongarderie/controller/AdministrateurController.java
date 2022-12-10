package com.ensa.gestiongarderie.controller;

import com.ensa.gestiongarderie.entities.Administrateur;
import com.ensa.gestiongarderie.mapping.Connection;
import com.ensa.gestiongarderie.repositories.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
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

    @PostMapping("/connection")
    public boolean verifierCompte(@RequestBody Connection connection){
        Administrateur a=administrateurRepository.findByEmail(connection.getEmail());
        if(a!=null){
            if(a.getMotDePasse().equals(connection.getPassword())){
                return  true;
            }
        }
      return  false ;
    }
}
