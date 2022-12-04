package com.ensa.gestiongarderie.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Niveau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private int minAge;
    private int maxAge;

    @OneToMany(mappedBy = "niveau")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Activite> activites=new ArrayList<>();

    @OneToMany(mappedBy = "niveau")
    private List<AideEducateur> aideEducateurs=new ArrayList<>();

    @OneToMany(mappedBy = "niveau")
    private List<Enfant> enfants=new ArrayList<>();
}
