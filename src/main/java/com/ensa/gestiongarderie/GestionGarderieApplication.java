package com.ensa.gestiongarderie;

import com.ensa.gestiongarderie.entities.Activite;
import com.ensa.gestiongarderie.entities.Administrateur;
import com.ensa.gestiongarderie.entities.Niveau;
import com.ensa.gestiongarderie.repositories.ActiviteRepository;
import com.ensa.gestiongarderie.repositories.AdministrateurRepository;
import com.ensa.gestiongarderie.repositories.NiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class GestionGarderieApplication implements CommandLineRunner {
    @Autowired
    AdministrateurRepository administrateurRepository;
    @Autowired
    NiveauRepository niveauRepository;
    @Autowired
    ActiviteRepository activiteRepository;
    public static void main(String[] args) {
        SpringApplication.run(GestionGarderieApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        if(administrateurRepository.findByEmail("admin@gmail.com")==null)
            administrateurRepository.save(new Administrateur("admin","admin","admin@gmail.com","123"));
        Niveau niveau1=new Niveau("Niveau 1",2,4,null,null,null);
        Niveau niveau2=new Niveau("Niveau 2",5,8,null,null,null);
        Niveau niveau3=new Niveau("Niveau 3",9,14,null,null,null);
        Activite activite1=new Activite("ACTIVITÉS SENSORIELLES","(regarder, toucher, entendre)",1000);
        Activite activite2=new Activite("ACTIVITÉS D’ARTS PLASTIQUES","(painture, musique, sculpture)",2000);
        Activite activite3=new Activite("ACTIVITÉS SOCIOAFFECTIVES ET MORALES","(communication, théatre, Histoire)",3000);
        Activite activite4=new Activite("ACTIVITÉS COGNITIVES","(puzzle, jeux de reflexion, enigmes)",1500);
        Activite activite5=new Activite("ACTIVITÉS PHYSIQUES ET MOTRICES","(course, sports, jeux de jardins)",1000);
        Activite activite6=new Activite("ACTIVITÉS LANGUES","(Français, Anglais,Arabe)",4000);
        Activite activite7=new Activite("SIESTE","(un bon confort pour dormir)",1000);
        Activite activite8=new Activite("NOURRITURE","(petit-dejeuné, déjeuné, diner)",5000);
        Activite activite9=new Activite("CALCUL MENTAL","(calcul rapide et correcte)",5000);
        if(activiteRepository.findByNom(activite1.getNom())==null)
            activiteRepository.save(activite1);
        if(activiteRepository.findByNom(activite2.getNom())==null)
            activiteRepository.save(activite2);
        if(activiteRepository.findByNom(activite3.getNom())==null)
            activiteRepository.save(activite3);
        if(activiteRepository.findByNom(activite4.getNom())==null)
            activiteRepository.save(activite4);
        if(activiteRepository.findByNom(activite5.getNom())==null)
            activiteRepository.save(activite5);
        if(activiteRepository.findByNom(activite6.getNom())==null)
            activiteRepository.save(activite6);
        if(activiteRepository.findByNom(activite7.getNom())==null)
            activiteRepository.save(activite7);
        if(activiteRepository.findByNom(activite8.getNom())==null)
            activiteRepository.save(activite8);
        if(activiteRepository.findByNom(activite9.getNom())==null)
            activiteRepository.save(activite9);

        List<Activite> activites1=new ArrayList<>();
            activites1.add(activite1);
            activites1.add(activite7);
            activites1.add(activite8);
            activites1.add(activite2);
            List<Activite> activites2=new  ArrayList<>();
            activites2.add(activite2);
            activites2.add(activite3);
            activites2.add(activite8);
            activites2.add(activite9);
            activites2.add(activite6);
            List<Activite> activites3=new  ArrayList<>();
            activites3.add(activite2);
            activites3.add(activite7);
            activites3.add(activite8);
            activites3.add(activite4);
            activites3.add(activite5);
            activites3.add(activite6);
            niveau1.setActivites(activites1);
            niveau2.setActivites(activites2);
            niveau3.setActivites(activites3);

            if(niveauRepository.findByNom(niveau1.getNom())==null)
                 niveauRepository.save(niveau1);

            if(niveauRepository.findByNom(niveau2.getNom())==null)
                 niveauRepository.save(niveau2);

            if(niveauRepository.findByNom(niveau3.getNom())==null)
                 niveauRepository.save(niveau3);
        for (Niveau niveau : niveauRepository.findAll()) {
            for (Activite activite : niveau.getActivites()) {
                System.out.println(activite);
            }
        }
    }
}
