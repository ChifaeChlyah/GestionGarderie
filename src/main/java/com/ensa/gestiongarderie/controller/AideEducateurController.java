package com.ensa.gestiongarderie.controller;


import com.ensa.gestiongarderie.entities.AideEducateur;
import com.ensa.gestiongarderie.repositories.AideEducateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController @RequestMapping("/aideEducateur")

public class AideEducateurController {

    @Autowired
    AideEducateurRepository aideEducateurRepository ;
    @GetMapping()
    public List<AideEducateur> allEnfant()
    {
        return aideEducateurRepository.findAll();
    }


    @PostMapping()
    public boolean addEnfant(@RequestBody AideEducateur ad)
    {
        if(aideEducateurRepository.findById(ad.getId()).isPresent())
            return false;
        aideEducateurRepository.save(ad);
        return true;
    }
}
