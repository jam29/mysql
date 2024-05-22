package org.example;
import java.sql.*;

public class MySQLExample2 {

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cinetest";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // Register MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to MySQL database
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            if (connection != null) {
                System.out.println("Connected to the database cinetest!");

                String sqlInsert = "INSERT INTO acteur (nom,prenom,photo) VALUES (?,?,?)";
                preparedStatement = connection.prepareStatement(sqlInsert);
                preparedStatement.setString(1,"EASTWOOD");
                preparedStatement.setString(2,"CLIENT");
                preparedStatement.setString(3,"clint.jpg");
                int row =  preparedStatement.executeUpdate();
                if (row > 0) {
                    System.out.println("Record inserted successfully!");
                } else {
                    System.out.println("Failed to insert record!");
                }
                preparedStatement.close();

            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found!");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
        } finally {
            // Close the connection
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());

            }
        }
    }
}
