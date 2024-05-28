package org.example.model;

import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ActeurDAO {
    public List getActeurs() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Acteur> query =   session.createQuery("from Acteur" ,Acteur.class);  // HQL
        List<Acteur> acteurs = query.getResultList();
        return (acteurs);
    }
    public Acteur getActeur(int id) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            return (session.get(Acteur.class,id));
    }

    public Acteur getActeurByName(String nom) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Acteur> query =   session.createNamedQuery("by_nom" ,Acteur.class);
        query.setParameter("nom", nom);
        Acteur acteur = query.getSingleResult();
        return acteur;

        // HQL

    }


    }
