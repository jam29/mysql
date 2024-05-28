package org.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String genre;

    @OneToMany(mappedBy = "genre",cascade = CascadeType.ALL)
    private List<Film> films = new ArrayList<Film>();

    public Genre(String genre) {
        this.genre = genre;
    }
    public Genre() {}

    public int getId() {
        return id;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
