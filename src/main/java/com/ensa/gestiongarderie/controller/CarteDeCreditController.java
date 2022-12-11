package com.ensa.gestiongarderie.controller;

import com.ensa.gestiongarderie.entities.Activite;
import com.ensa.gestiongarderie.entities.CarteDeCredit;
import com.ensa.gestiongarderie.repositories.ActiviteRepository;
import com.ensa.gestiongarderie.repositories.CarteDeCreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/carteDeCredit")
public class CarteDeCreditController {
    @Autowired
    CarteDeCreditRepository carteDeCreditRepository;
    @PostMapping()
    public boolean addCarteDeCredit(@RequestBody CarteDeCredit carteDeCredit)
    {
        if(carteDeCreditRepository.findById(carteDeCredit.getId()).isPresent())
            return false;
        carteDeCreditRepository.save(carteDeCredit);
        return true;
    }
}
