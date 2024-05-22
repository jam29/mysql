package org.example.model;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ActeurDAO {
    Connection con = null;

    // Database Connection will use jdbc driver from the mysql connector jar
    public void Dbconnect() {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            // connection to mysql
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinetest", "root", "");
            MysqlDataSource ds = new MysqlDataSource();
            ds.setUseSSL(false);
            ds.setServerName("localhost");
            ds.setPort(3306);
            ds.setDatabaseName("cinetest");
            ds.setUser("root");
            ds.setPassword("");
            con = ds.getConnection();



        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public List getActeurs() {

        List<Acteur> acteurs = new ArrayList<Acteur>();
        String query = "SELECT * FROM acteur";
        try {

            Statement statement = con.createStatement();
            ResultSet rs= statement.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                // casting d'objet.
                // Acteur acteur= (Acteur) rs.getObject(i);
                Acteur act = new Acteur();
                act.setId(id);
                act.setNom(rs.getString("nom"));
                act.setPrenom(rs.getString("prenom"));
                act.setPhoto(rs.getString("photo"));

                acteurs.add(act);

            }
        } catch (Exception e) {}
        return acteurs;
    }
    public void addActeur(Acteur act) {
        // insert query
        // using prepared statements
        String query = "INSERT INTO acteur (nom,prenom,photo) VALUES (?,?,?)";
        try {
            PreparedStatement pst;
            pst = con.prepareStatement(query);
            pst.setString(1, act.getNom());
            pst.setString(2, act.getPhoto());
            pst.setString(3,act.getPhoto());

            pst.executeUpdate(); // executeUpdate is used for the insertion of the data
            System.out.println("acteur ajouté!");
        } catch (Exception ex) {
        }
    }
}