package com.ensa.gestiongarderie.servicesImpl;

import com.ensa.gestiongarderie.services.PaymentStrategy;

import java.util.Date;

public class CarteDeCreditStrategy implements PaymentStrategy {
    private String numeroCarte;
    private String cryptogramme;
    private Date DateExpiration;

    public CarteDeCreditStrategy() {
    }

    public CarteDeCreditStrategy(String numeroCarte, String cryptogramme, Date dateExpiration) {
        this.numeroCarte = numeroCarte;
        this.cryptogramme = cryptogramme;
        DateExpiration = dateExpiration;
    }

    @Override
    public boolean payer(double prix) {

        return true;
    }
}
