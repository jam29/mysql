package org.example.model;

import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class FilmDAO {
    public List getFilms() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Film> query =   session.createQuery("from Film" ,Film.class);  // HQL
        List<Film> films = query.getResultList();
        return (films);
    }
}
