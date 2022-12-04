package com.ensa.gestiongarderie.controller;

import com.ensa.gestiongarderie.entities.CarteDeCredit;
import com.ensa.gestiongarderie.entities.Paypal;
import com.ensa.gestiongarderie.repositories.CarteDeCreditRepository;
import com.ensa.gestiongarderie.repositories.PaypalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paypal")
public class PaypalController {
    @Autowired
    PaypalRepository paypalRepository;
    @PostMapping()
    public boolean addPaypal(@RequestBody Paypal paypal)
    {
        if(paypalRepository.findById(paypal.getId()).isPresent())
            return false;
        paypalRepository.save(paypal);
        return true;
    }
}
