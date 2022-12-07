package com.ensa.gestiongarderie.factory_service;

import com.ensa.gestiongarderie.entities.Enfant;
import com.ensa.gestiongarderie.entities.EnfantAutiste;
import com.ensa.gestiongarderie.entities.EnfantHyperactif;
import com.ensa.gestiongarderie.entities.EnfantSurdoue;
import com.ensa.gestiongarderie.enums.TypeEnfant;
import org.springframework.stereotype.Service;

@Service
public class EnfantFactory {
    public Enfant getEnfant(Enfant enfant, TypeEnfant typeEnfant)
    {
        switch (typeEnfant)
        {

            case ENFANT_AUTISTE:
            {
                return new EnfantAutiste(enfant);
            }
            case ENFANT_SURDOUE:
            {
                return new EnfantSurdoue(enfant);
            }
            case ENFANT_HYPERACTIF:
            {
                return new EnfantHyperactif(enfant);
            }
            case ENFANT_AUTISTE_ET_HYPERACTIF:
            {
                EnfantHyperactif enfantHyperactif=new EnfantHyperactif(enfant);
                return new EnfantAutiste(enfantHyperactif);
            }
            case ENFANT_SURDOUE_ET_HYPERACTIF:
            {
                EnfantHyperactif enfantHyperactif=new EnfantHyperactif(enfant);
                return new EnfantSurdoue(enfantHyperactif);
            }
            case ENFANT_AUTISTE_ET_SURDOUE:
            {
                EnfantSurdoue enfantSurdoue=new EnfantSurdoue(enfant);
                return new EnfantAutiste(enfantSurdoue);
            }
            case ENFANT_AUTIST_ET_HYPERACTIF_ET_SURDOUE:
            {
                EnfantSurdoue enfantSurdoue=new EnfantSurdoue(enfant);
                EnfantHyperactif enfantHyperactif=new EnfantHyperactif(enfantSurdoue);
                return new EnfantAutiste(enfantHyperactif);
            }
            default: {
                return enfant;
            }
        }
    }
}
