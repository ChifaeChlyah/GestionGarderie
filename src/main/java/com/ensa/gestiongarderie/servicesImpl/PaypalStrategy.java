package com.ensa.gestiongarderie.servicesImpl;

import com.ensa.gestiongarderie.services.PaymentStrategy;

public class PaypalStrategy implements PaymentStrategy {
    private String identifiant;
    private String password;

    public PaypalStrategy(String identifiant, String password) {
        this.identifiant = identifiant;
        this.password = password;
    }

    public PaypalStrategy() {
    }

    @Override
    public boolean payer(double prix) {
        return true;
    }
}
