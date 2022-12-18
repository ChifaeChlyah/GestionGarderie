package com.ensa.gestiongarderie.factory_service;

import com.ensa.gestiongarderie.angularClasses.DonnessPayment;
import com.ensa.gestiongarderie.services.PaymentStrategy;
import com.ensa.gestiongarderie.servicesImpl.CarteDeCreditStrategy;
import com.ensa.gestiongarderie.servicesImpl.PaypalStrategy;
import org.springframework.stereotype.Service;

@Service
public class PayementStrategyFactory {
    public PaymentStrategy getStrategy(String strategy, DonnessPayment donnessPayment){
        PaymentStrategy paymentStrategy;
        if(strategy.equals("paypal")) {
            paymentStrategy = new PaypalStrategy();
            ((PaypalStrategy)paymentStrategy).setIdentifiant(donnessPayment.getIdentifiant());
            ((PaypalStrategy)paymentStrategy).setPassword(donnessPayment.getPassword());
        }
        else {
            paymentStrategy = new CarteDeCreditStrategy();
            ((CarteDeCreditStrategy)paymentStrategy).setNumeroCarte(donnessPayment.getNumeroCarte());
            ((CarteDeCreditStrategy)paymentStrategy).setCryptogramme(donnessPayment.getCryptogramme());
        }
        return paymentStrategy;
    }
}
