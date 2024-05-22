package org.example;
import java.sql.*;

public class MySQLExample {

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cinetest";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Register MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to MySQL database
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            if (connection != null) {
                System.out.println("Connected to the database coin coin!");
                // You can perform database operations here
                //----
                Statement statement = connection.createStatement();

                // Execute a SQL query
                String sqlQuery = "SELECT * FROM acteur";
                ResultSet resultSet = statement.executeQuery(sqlQuery);

//                // Process the result set
                while (resultSet.next()) {
                    // Retrieve data from the result set
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("nom");
                    String fname = resultSet.getString("prenom");
                    String photo = resultSet.getString("photo");
                    // Print data
                    System.out.println("ID: " + id + ", Name: " + name + " " + fname + " "+ photo);
                }
//
//                // Close the result set and statement
//                resultSet.close();
//                statement.close();
//

                //----
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        } finally {
            // Close the connection
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
