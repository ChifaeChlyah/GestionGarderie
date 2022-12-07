package com.ensa.gestiongarderie.entities;

import com.ensa.gestiongarderie.repositories.EnfantRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class EnfantSpecial extends Enfant{
    Enfant enfant;
    final Double tarifPyschologue=1000.;
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
        enfant.setNom(nom);
    } 
    @Override
    public void setPrenom(String prenom) {
        super.setPrenom(prenom);
        enfant.setPrenom(prenom);
    }
    @Override
    public void setAge(int age) {
        super.setAge(age);
        enfant.setAge(age);
    }
    @Override
    public void setNiveau(Niveau niveau) {
        super.setNiveau(niveau);
        enfant.setNiveau(niveau);
    }
    @Override
    public void setParent(Parent parent) {
        super.setParent(parent);
        enfant.setParent(parent);
    }

    public Enfant getEnfant()
    {
        return enfant;
    }
}
