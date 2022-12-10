package com.ensa.gestiongarderie.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class EnfantHyperactif extends EnfantSpecial{
    @Id
    long id;
    @ManyToOne

    private AideEducateur specialiste_Hyperactivite;

    @OneToMany
    @JoinTable(name = "enfant_activites_hyperactif")
    private Collection<Activite> activitesSpeciales_hyperactifs=new ArrayList<>();

    public EnfantHyperactif(Enfant enfant) {
        super(enfant);
    }
    @Override
    public Double cout() {
        double cout=0;
        for (Activite activite : activitesSpeciales_hyperactifs) {
            cout+=activite.getPrix();
        }

        cout+=tarifPyschologue;
        if(getEnfant()!=null)
            cout+=getEnfant().cout() ;
        return  cout;
    }
}
