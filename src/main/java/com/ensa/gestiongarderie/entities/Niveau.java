package com.ensa.gestiongarderie.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Niveau {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nom;
    private int minAge;
    private int maxAge;

    public Niveau(String nom, int minAge, int maxAge, Set<Activite> activites, List<AideEducateur> aideEducateurs, List<Enfant> enfants) {
        this.nom = nom;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.activites = activites;
        this.aideEducateurs = aideEducateurs;
        this.enfants = enfants;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Activite> activites=new ArrayList<>();

    @OneToMany(mappedBy = "niveau")
    private List<AideEducateur> aideEducateurs=new ArrayList<>();

    @OneToMany(mappedBy = "niveau")
    private List<Enfant> enfants=new ArrayList<>();

}
