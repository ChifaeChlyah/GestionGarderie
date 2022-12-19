package com.ensa.gestiongarderie.entities;

import com.ensa.gestiongarderie.repositories.EnfantRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class EnfantSpecial implements IEnfant{
    long id;
    IEnfant enfant;
    @JsonIgnore @Transient
    final double tarifPyschologue=1000;
    public EnfantSpecial() {
    }
    public void setEnfant(IEnfant enfant) {
        this.enfant = enfant;
    }
    @Autowired
    EnfantRepository enfantRepository;
    public EnfantSpecial(Enfant enfant) {
        this.enfant=enfant;
    }
    public EnfantHyperactif convertToHyperactif()
    {
        EnfantHyperactif enfantHyperactif=new EnfantHyperactif();
        enfantHyperactif.setId(id);
        return  enfantHyperactif;
    }
    public EnfantAutiste convertToAutiste()
    {
        EnfantAutiste enfantAutiste=new EnfantAutiste();
        enfantAutiste.setId(id);
        return  enfantAutiste;
    }
    public EnfantSurdoue convertToSurdoue()
    {
        EnfantSurdoue enfantSurdoue=new EnfantSurdoue();
        enfantSurdoue.setId(id);
        return  enfantSurdoue;
    }

    public IEnfant getEnfant()
    {
        return enfant;
    }
}
