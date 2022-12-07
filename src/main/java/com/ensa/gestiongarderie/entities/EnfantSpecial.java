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


public abstract class EnfantSpecial extends Enfant{
    @OneToOne @Nullable
    Enfant enfant;
    @JsonIgnore @Transient
    final double tarifPyschologue=1000;
    public EnfantSpecial() {
    }

    public void setEnfant(Enfant enfant) {
        this.enfant = enfant;
    }

    @Autowired
    EnfantRepository enfantRepository;
    @Override
    public Double cout(){
        return enfant.cout();
    }
    public EnfantSpecial(Enfant enfant) {
        super(enfant.getId(), enfant.getNom(), enfant.getPrenom(), enfant.getAge(),enfant.getNiveau(),enfant.getParent());
        this.enfant=enfant;
    }
    
    @Override
    public void setNom(String nom) {
        super.setNom(nom);
        if(enfant!=null)
            enfant.setNom(nom);
    } 
    @Override
    public void setPrenom(String prenom) {
        super.setPrenom(prenom);
        if(enfant!=null)
            enfant.setPrenom(prenom);
    }
    @Override
    public void setAge(int age) {
        super.setAge(age);
        if(enfant!=null)
            enfant.setAge(age);
    }
    @Override
    public void setNiveau(Niveau niveau) {
        super.setNiveau(niveau);
        if(enfant!=null)
            enfant.setNiveau(niveau);
    }
    @Override
    public void setParent(Parent parent) {
        super.setParent(parent);
        if(enfant!=null)
            enfant.setParent(parent);
    }

    public Enfant getEnfant()
    {
        return enfant;
    }
}
