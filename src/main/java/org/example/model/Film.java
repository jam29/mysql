package org.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titre;
    private String description;
    private String affiche ;
    @ManyToOne
    @JoinColumn(name = "genre") // colonne genre de la table genre
    private Genre genre;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "joue",
            joinColumns = { @JoinColumn(name = "id_film") },
            inverseJoinColumns = { @JoinColumn(name = "id_acteur") }
    )
    private List<Acteur> acteurs;

    public Film(){}
    public Film(int id, String titre, String description, String affiche) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.affiche = affiche;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAffiche() {
        return affiche;
    }

    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }


    public List<Acteur> getActeurs(){
        return this.acteurs;
    }



}
