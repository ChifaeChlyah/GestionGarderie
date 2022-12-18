package com.ensa.gestiongarderie.angularClasses;

import com.ensa.gestiongarderie.entities.Enfant;
import com.ensa.gestiongarderie.entities.IEnfant;
import com.ensa.gestiongarderie.entities.Niveau;
import com.ensa.gestiongarderie.entities.Parent;
import com.ensa.gestiongarderie.factory_service.EnfantFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class Enfant_type {
    private long id ;
    private String nom ;
    private String prenom ;
    int age;
    String type;
    private Niveau niveau;
    private Parent parent;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
    public void enfantToEnfant_type(Enfant enfant)
    {
        this.id= enfant.getId();
        this.age=enfant.getAge();
        this.nom=enfant.getNom();
        this.prenom=enfant.getPrenom();
        this.parent=enfant.getParent();
        this.niveau=enfant.getNiveau();
        this.parent=enfant.getParent();
    }
}
