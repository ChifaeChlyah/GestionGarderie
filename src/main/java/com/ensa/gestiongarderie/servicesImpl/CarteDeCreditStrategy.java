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
        comptes_paypal.put("compte1","pass1");
        comptes_paypal.put("compte2","pass2");
        comptes_paypal.put("compte3","pass3");
    }
    private String numeroCarte;
    private String cryptogramme;
    private Date DateExpiration;

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

    public Date getDateExpiration() {
        return DateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        DateExpiration = dateExpiration;
    }

    public CarteDeCreditRepository getCarteDeCreditRepository() {
        return carteDeCreditRepository;
    }

    public void setCarteDeCreditRepository(CarteDeCreditRepository carteDeCreditRepository) {
        this.carteDeCreditRepository = carteDeCreditRepository;
    }

    @Autowired
    CarteDeCreditRepository carteDeCreditRepository;



    public CarteDeCreditStrategy(String numeroCarte, String cryptogramme, Date dateExpiration) {
        this.numeroCarte = numeroCarte;
        this.cryptogramme = cryptogramme;
        DateExpiration = dateExpiration;
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
