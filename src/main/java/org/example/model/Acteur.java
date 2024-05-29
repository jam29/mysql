package org.example.model;

import javax.persistence.*;
import java.util.List;

// Modele
@NamedQuery(query = "from Acteur where nom=:nom", name= "by_nom")
@Entity
public class Acteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String photo;

//    @ManyToMany(mappedBy="acteurs") // ici acteurs correspond aux acteurs de l'entity film
//    private List<Film> films;

    public Acteur() {}
    public Acteur(int id, String nom, String prenom, String photo) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.photo = photo;
    }
    public int getId() {
        return this.id;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getPhoto() {
        return photo;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
