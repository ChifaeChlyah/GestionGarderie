package com.ensa.gestiongarderie.controller;

<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parent")
=======
import com.ensa.gestiongarderie.entities.AideEducateur;
import com.ensa.gestiongarderie.entities.Enfant;
import com.ensa.gestiongarderie.repositories.AideEducateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/aideEducateur")
>>>>>>> e0bef0d8de40ca767bcb1591a1d3037dec056f19
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
