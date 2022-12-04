package com.ensa.gestiongarderie.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor  @NoArgsConstructor
public class Parent {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String  cne  ;
    private String  nom ;
    private String prenom ;
    private String email ;
    private String motDePasse;
    private String  tel ;
    private boolean statutPayement;

    @OneToOne(mappedBy = "parent")
    Enfant enfant;
}
