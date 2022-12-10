package com.ensa.gestiongarderie.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class EnfantSurdoue extends EnfantSpecial{
    @Id
    long id;
    double quotientIntellectuel=150.;

    @OneToMany
    @JoinTable(name = "enfant_activites_surdoué")
    private Collection<Activite> activiteAdditionelles=new ArrayList<>();

    public EnfantSurdoue(Enfant enfant) {
        super(enfant);
    }
    @Override
    public Double cout() {
        double cout=0;
        for (Activite activite : activiteAdditionelles) {
            cout+=activite.getPrix();
        }
        cout+=tarifPyschologue;
        if(getEnfant()!=null)
            cout+= getEnfant().cout() ;
        return  cout;
    }
}
