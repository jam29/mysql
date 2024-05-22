package org.example.view;

import org.example.model.Acteur;

import java.util.List;

public class ActeurView {
    public void afficheActeurs(List<Acteur> acteurs) {
        System.out.println("Liste:");
        for(Acteur acteur: acteurs) {
            System.out.println(acteur.getNom()+" "+acteur.getPrenom());
        }
    }

    public void afficheActeur(int id , List<Acteur> acteurs) {
        for(Acteur acteur: acteurs) {
            if (acteur.getId() == id) {
                System.out.println(acteur.getNom() + " " + acteur.getPrenom());
            }
        }
    }
}

