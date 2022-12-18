package com.ensa.gestiongarderie.angularClasses;

public class DonnessPayment {
    private String identifiant;
    private String password;
    private String numeroCarte;
    private String cryptogramme;

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
}
