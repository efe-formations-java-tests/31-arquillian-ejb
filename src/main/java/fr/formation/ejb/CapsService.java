package fr.formation.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CapsService {

    @EJB
    private CapsConvertisseur capsConvertisseur;

    public String getConvertedCaps(final String word){
        return capsConvertisseur.getLowerCase().convert(word);
    }
}