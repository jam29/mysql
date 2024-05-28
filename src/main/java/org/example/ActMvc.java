package org.example;

import org.example.controller.ActeurController;
import org.example.model.Acteur;
import org.example.model.ActeurDAO;
import org.example.model.Genre;
import org.example.model.GenreDAO;
import org.example.model.Film;
import org.example.model.FilmDAO;

import java.util.List;

public class ActMvc {
    public static void main(String[] args) {
        ActeurController ac = new ActeurController();
        ActeurDAO acteurDAO = new ActeurDAO(); // constructor
        GenreDAO genreDao = new GenreDAO();
        FilmDAO filmDao = new FilmDAO();

//        List<Acteur> acteurs = acteurDAO.getActeurs();
//        for(Acteur act: acteurs) {
//            ac.addActeur(act);
//        }
//        ac.afficheActeurs();
//        Acteur act = acteurDAO.getActeur(2);
//        System.out.println(act.getNom());

//        List<Genre> genres = genreDao.getGenres();
//        for(Genre g: genres) {
//            System.out.println(g.getGenre());
//        }

//        List<Film> films = filmDao.getFilms() ;
//            for(Film f: films) {
//                System.out.println(f.getTitre()+":"+f.getGenre().getGenre());
//                for(Acteur a:f.getActeurs()) {
//                    System.out.println(a.getNom()+" "+a.getPrenom());
//                }
//            }
//        }

        Acteur act = acteurDAO.getActeurByName("Belmondo") ;
        System.out.println(act.getPrenom());
    }


}