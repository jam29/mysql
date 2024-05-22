package org.example.controller;

import org.example.view.ActeurView;
import org.example.model.Acteur;

import java.util.ArrayList;
import java.util.List;

public class ActeurController {
    private List<Acteur> Acteurs ;
    private ActeurView viewActeur ;
    public ActeurController() {
        this.Acteurs = new ArrayList();
        this.viewActeur = new ActeurView();
    }

    public void addActeur(Acteur act) {
        Acteurs.add(act);
    }
    public void afficheActeurs() {
        viewActeur.afficheActeurs(Acteurs);
    }

    public void afficheActeur(int id) {
        viewActeur.afficheActeur(id,Acteurs);
    }
}
