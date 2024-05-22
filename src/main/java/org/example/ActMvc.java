package org.example;

import org.example.controller.ActeurController;
import org.example.model.Acteur;
import org.example.model.ActeurDAO;

import java.util.List;

public class ActMvc {
    public static void main(String[] args) {
        ActeurController ac = new ActeurController();
        ActeurDAO acteurDAO = new ActeurDAO(); // constructor
        acteurDAO.Dbconnect();

        List<Acteur> acteurs = acteurDAO.getActeurs();
        for(Acteur act: acteurs) {
            ac.addActeur(act);
        }

        ac.afficheActeurs();
        ac.afficheActeur(2);
    }
}
