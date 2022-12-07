package com.ensa.gestiongarderie.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class EnfantSurdoue extends EnfantSpecial{
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    long id;
    double quotientIntellectuel;

    @OneToMany
    @JoinTable(name = "enfant_activites_surdoué")
    private Collection<Activite> activiteAdditionelles=new ArrayList<>();

    public EnfantSurdoue(Enfant enfant) {
        super(enfant);
    }
    @Override
    public Double cout() {
        double cout=super.cout();
        for (Activite activite : activiteAdditionelles) {
            cout+=activite.getPrix();
        }
        return  cout;
    }
}
