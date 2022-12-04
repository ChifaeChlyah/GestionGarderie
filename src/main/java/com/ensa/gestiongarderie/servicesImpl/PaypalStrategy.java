package com.ensa.gestiongarderie.servicesImpl;

import com.ensa.gestiongarderie.entities.Paypal;
import com.ensa.gestiongarderie.repositories.PaypalRepository;
import com.ensa.gestiongarderie.services.PaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;

public class PaypalStrategy implements PaymentStrategy {
    private String identifiant;
    private String password;
    @Autowired
    PaypalRepository paypalRepository;
    public PaypalStrategy(String identifiant, String password) {
        this.identifiant = identifiant;
        this.password = password;
    }

    public PaypalStrategy() {
    }

    @Override
    public boolean payer(double prix) {
        Paypal paypal=paypalRepository.findByIdentifiant(identifiant);
        if(paypal==null)
            return false;
        if(paypal.getPassword()!=password)
            return false;
        if(paypal.getSolde()<prix)
            return false;
        paypal.setSolde(paypal.getSolde()-prix);
        paypalRepository.save(paypal);
        return true;
    }
}
