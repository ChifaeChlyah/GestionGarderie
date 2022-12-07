package com.ensa.gestiongarderie.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Bag;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnfantAutiste extends EnfantSpecial{
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    long id;
    @ManyToOne
    private AideEducateur specialiste_Autisme;

    @OneToMany
    @JoinTable(name = "enfant_activites_autisme")
    private Collection<Activite> activitesSpeciales_autisme=new ArrayList<>();

    public EnfantAutiste(Enfant enfant) {
        super(enfant);
    }

    @Override
    public Double cout() {
        double cout=super.cout();
        for (Activite activite : activitesSpeciales_autisme) {
            cout+=activite.getPrix();
        }
        cout+=tarifPyschologue;
        return  cout;
    }
}
