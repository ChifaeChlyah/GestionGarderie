package com.ensa.gestiongarderie.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data @NoArgsConstructor
//@Inheritance(strategy = InheritanceType.JOINED)
public class Enfant implements IEnfant{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String nom ;
    private String prenom ;
    int age;
    public Double cout(){
        double cout=0.;
        if(niveau!=null)
            for (Activite activite : niveau.getActivites()) {
                cout+=activite.getPrix();
            }
        return cout;
    }
    @ManyToOne
    private Niveau niveau;

    public Enfant(long id, String nom, String prenom, int age, Niveau niveau, Parent parent) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.niveau = niveau;
        this.parent = parent;
    }
    public Enfant(long id, String nom, String prenom, int age)
    {
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.age=age;
    }
    @OneToOne(cascade=CascadeType.ALL)
    private Parent parent;
    public EnfantHyperactif convertToHyperactif()
    {
        EnfantHyperactif enfantHyperactif=new EnfantHyperactif();
        enfantHyperactif.setId(id);
        return  enfantHyperactif;
    }
    public EnfantAutiste convertToAutiste()
    {
        EnfantAutiste enfantAutiste=new EnfantAutiste();
        enfantAutiste.setId(id);
        return  enfantAutiste;
    }
    public EnfantSurdoue convertToSurdoue()
    {
        EnfantSurdoue enfantSurdoue=new EnfantSurdoue();
        enfantSurdoue.setId(id);
        return  enfantSurdoue;
    }
}
