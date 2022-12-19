package com.ensa.gestiongarderie.servicesImpl;

import com.ensa.gestiongarderie.entities.CarteDeCredit;
import com.ensa.gestiongarderie.entities.Paypal;
import com.ensa.gestiongarderie.repositories.CarteDeCreditRepository;
import com.ensa.gestiongarderie.services.PaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;

public class CarteDeCreditStrategy implements PaymentStrategy {
    HashMap<String,String> comptes_paypal=new HashMap<>();
    public CarteDeCreditStrategy()
    {
        comptes_paypal.put("num1","crypt1");
        comptes_paypal.put("num2","crypt2");
        comptes_paypal.put("num3","crypt3");
    }
    private String numeroCarte;
    private String cryptogramme;
//    private Date DateExpiration;
    public String getNumeroCarte() {
        return numeroCarte;
    }
    public void setNumeroCarte(String numeroCarte) {
        this.numeroCarte = numeroCarte;
    }
    public String getCryptogramme() {
        return cryptogramme;
    }
    public void setCryptogramme(String cryptogramme) {
        this.cryptogramme = cryptogramme;
    }
    public CarteDeCreditStrategy(String numeroCarte, String cryptogramme, Date dateExpiration) {
        this.numeroCarte = numeroCarte;
        this.cryptogramme = cryptogramme;
    }
    @Override
    public boolean payer(double prix) {
        String cryptogramme=comptes_paypal.get(this.cryptogramme);
        if(cryptogramme==null)
            return false;
        if(!cryptogramme.equals(this.cryptogramme))
            return false;
        return true;
    }

}
