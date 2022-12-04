package com.ensa.gestiongarderie.services;

public interface PaymentStrategy {
    public boolean payer(double prix);
}
