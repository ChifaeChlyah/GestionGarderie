package com.ensa.gestiongarderie.servicesImpl;

import com.ensa.gestiongarderie.entities.CarteDeCredit;
import com.ensa.gestiongarderie.entities.Paypal;
import com.ensa.gestiongarderie.repositories.CarteDeCreditRepository;
import com.ensa.gestiongarderie.services.PaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class CarteDeCreditStrategy implements PaymentStrategy {
    private String numeroCarte;
    private String cryptogramme;
    private Date DateExpiration;
    @Autowired
    CarteDeCreditRepository carteDeCreditRepository;

    public CarteDeCreditStrategy() {
    }

    public CarteDeCreditStrategy(String numeroCarte, String cryptogramme, Date dateExpiration) {
        this.numeroCarte = numeroCarte;
        this.cryptogramme = cryptogramme;
        DateExpiration = dateExpiration;
    }

    @Override
    public boolean payer(double prix) {
        CarteDeCredit carteDeCredit=carteDeCreditRepository.findByNumeroCarte(numeroCarte);
        if(carteDeCredit==null)
            return false;
        if(carteDeCredit.getCryptogramme()!=cryptogramme)
            return false;
        if(carteDeCredit.getSolde()<prix)
            return false;
        carteDeCredit.setSolde(carteDeCredit.getSolde()-prix);
        carteDeCreditRepository.save(carteDeCredit);
        return true;
    }
}
