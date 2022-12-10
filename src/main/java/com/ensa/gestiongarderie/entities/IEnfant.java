package com.ensa.gestiongarderie.entities;

public interface IEnfant {
    Double cout();
    public EnfantHyperactif convertToHyperactif();
    public EnfantAutiste convertToAutiste();
    public EnfantSurdoue convertToSurdoue();
    long getId();
}
