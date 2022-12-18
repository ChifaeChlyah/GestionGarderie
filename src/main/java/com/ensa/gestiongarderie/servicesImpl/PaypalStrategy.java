package com.ensa.gestiongarderie.servicesImpl;

import com.ensa.gestiongarderie.entities.Paypal;
import com.ensa.gestiongarderie.repositories.PaypalRepository;
import com.ensa.gestiongarderie.services.PaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.HexFormat;

public class PaypalStrategy implements PaymentStrategy {
    HashMap<String,String> comptes_paypal=new HashMap<>();
    public PaypalStrategy()
    {
        comptes_paypal.put("compte1","pass1");
        comptes_paypal.put("compte2","pass2");
        comptes_paypal.put("compte3","pass3");
    }
    private String identifiant;
    private String password;

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public PaypalStrategy(String identifiant, String password) {
        this.identifiant = identifiant;
        this.password = password;
    }


    @Override
    public boolean payer(double prix) {
        String password=comptes_paypal.get(identifiant);
        if(password==null)
            return false;
        if(!password.equals(this.password))
            return false;
        return true;
    }
}
