package com.ensa.gestiongarderie.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Enfant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String nom ;
    private String prenom ;
    int age;
    public Double cout(){
        double cout=0.;
        for (Activite activite : niveau.getActivites()) {
            cout+=activite.getPrix();
        }
        return cout;
    }
    @ManyToOne
    private Niveau niveau;

    @OneToOne
    private Parent parent;

}
