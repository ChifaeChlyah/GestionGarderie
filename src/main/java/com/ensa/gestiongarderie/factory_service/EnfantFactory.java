package com.ensa.gestiongarderie.factory_service;

import com.ensa.gestiongarderie.entities.*;
import com.ensa.gestiongarderie.enums.TypeEnfant;
import com.ensa.gestiongarderie.repositories.EnfantAutisteRepository;
import com.ensa.gestiongarderie.repositories.EnfantHyperactifRepository;
import com.ensa.gestiongarderie.repositories.EnfantRepository;
import com.ensa.gestiongarderie.repositories.EnfantSurdoueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Service
public class EnfantFactory {
    
//    public Enfant getEnfant(Enfant enfant, TypeEnfant typeEnfant)
//    {
//        switch (typeEnfant)
//        {
//
//            case ENFANT_AUTISTE:
//            {
//                return new EnfantAutiste(enfant);
//            }
//            case ENFANT_SURDOUE:
//            {
//                return new EnfantSurdoue(enfant);
//            }
//            case ENFANT_HYPERACTIF:
//            {
//                return new EnfantHyperactif(enfant);
//            }
//            case ENFANT_AUTISTE_ET_HYPERACTIF:
//            {
//                EnfantHyperactif enfantHyperactif=new EnfantHyperactif(enfant);
//                return new EnfantAutiste(enfantHyperactif);
//            }
//            case ENFANT_HYPERACTIF_ET_SURDOUE:
//            {
//                EnfantSurdoue enfantSurdoue=new EnfantSurdoue(enfant);
//                return new EnfantHyperactif(enfantSurdoue);
//            }
//            case ENFANT_AUTISTE_ET_SURDOUE:
//            {
//                EnfantSurdoue enfantSurdoue=new EnfantSurdoue(enfant);
//                return new EnfantAutiste(enfantSurdoue);
//            }
//            case ENFANT_AUTIST_ET_HYPERACTIF_ET_SURDOUE:
//            {
//                EnfantSurdoue enfantSurdoue=new EnfantSurdoue(enfant);
//                EnfantHyperactif enfantHyperactif=new EnfantHyperactif(enfantSurdoue);
//                return new EnfantAutiste(enfantHyperactif);
//            }
//            default: {
//                return enfant;
//            }
//        }
//    }
    
    @Autowired
    EnfantRepository enfantRepository;
    @Autowired
    EnfantHyperactifRepository enfantHyperactifRepository;
    @Autowired
    EnfantSurdoueRepository enfantSurdoueRepository;
    @Autowired
    EnfantAutisteRepository enfantAutisteRepository;
    public TypeEnfant getTypeEnfant(Enfant enfant)
    {

        long id=enfant.getId();
        if(enfantAutisteRepository.findById(id).isPresent()
                &&enfantHyperactifRepository.findById(id).isPresent()
                &&enfantSurdoueRepository.findById(id).isPresent())
            return TypeEnfant.ENFANT_AUTIST_ET_HYPERACTIF_ET_SURDOUE;
        else if (enfantAutisteRepository.findById(id).isPresent()
                &&enfantHyperactifRepository.findById(id).isPresent())
            return TypeEnfant.ENFANT_AUTISTE_ET_HYPERACTIF;
        else if (enfantHyperactifRepository.findById(id).isPresent()
                &&enfantSurdoueRepository.findById(id).isPresent())
            return TypeEnfant.ENFANT_HYPERACTIF_ET_SURDOUE;
        else if (enfantAutisteRepository.findById(id).isPresent()
                &&enfantSurdoueRepository.findById(id).isPresent())
            return TypeEnfant.ENFANT_AUTISTE_ET_SURDOUE;
        else
            return TypeEnfant.ENFANT_NORMAL;

    }
    public IEnfant getEnfant(Enfant enfant)
    {
        TypeEnfant typeEnfant=getTypeEnfant(enfant);
        switch (typeEnfant)
        {

            case ENFANT_AUTISTE:
            {
                EnfantAutiste enfantAutiste= enfantAutisteRepository.findById(enfant.getId()).get();
                enfantAutiste.setEnfant(enfant);
                return enfantAutiste;
            }
            case ENFANT_SURDOUE:
            {
                EnfantSurdoue enfantSurdoue= enfantSurdoueRepository.findById(enfant.getId()).get();
                enfantSurdoue.setEnfant(enfant);
                return enfantSurdoue;
            }
            case ENFANT_HYPERACTIF:
            {
                EnfantHyperactif enfantHyperactif= enfantHyperactifRepository.findById(enfant.getId()).get();
                enfantHyperactif.setEnfant(enfant);
                return enfantHyperactif;
            }
            case ENFANT_AUTISTE_ET_HYPERACTIF:
            {
                EnfantAutiste enfantAutiste= enfantAutisteRepository.findById(enfant.getId()).get();
                EnfantHyperactif enfantHyperactif= enfantHyperactifRepository.findById(enfant.getId()).get();
                enfantHyperactif.setEnfant(enfant);
                enfantAutiste.setEnfant(enfantHyperactif);
                return enfantAutiste;
            }
            case ENFANT_HYPERACTIF_ET_SURDOUE:
            {
                EnfantHyperactif enfantHyperactif= enfantHyperactifRepository.findById(enfant.getId()).get();
                EnfantSurdoue enfantSurdoue= enfantSurdoueRepository.findById(enfant.getId()).get();
                enfantSurdoue.setEnfant(enfant);
                enfantHyperactif.setEnfant(enfantSurdoue);
                return enfantSurdoue;
            }
            case ENFANT_AUTISTE_ET_SURDOUE:
            {
                EnfantAutiste enfantAutiste= enfantAutisteRepository.findById(enfant.getId()).get();
                EnfantSurdoue enfantSurdoue= enfantSurdoueRepository.findById(enfant.getId()).get();
                enfantSurdoue.setEnfant(enfant);
                enfantAutiste.setEnfant(enfantSurdoue);
                return enfantAutiste;
            }
            case ENFANT_AUTIST_ET_HYPERACTIF_ET_SURDOUE:
            {
                EnfantAutiste enfantAutiste= enfantAutisteRepository.findById(enfant.getId()).get();
                EnfantHyperactif enfantHyperactif= enfantHyperactifRepository.findById(enfant.getId()).get();
                EnfantSurdoue enfantSurdoue= enfantSurdoueRepository.findById(enfant.getId()).get();
                enfantSurdoue.setEnfant(enfant);
                enfantHyperactif.setEnfant(enfantSurdoue);
                enfantAutiste.setEnfant(enfantHyperactif);
                return enfantAutiste;
            }
            default: {
                return enfant;
            }
        }
    }
}
