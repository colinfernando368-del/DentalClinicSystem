package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/dental_clinic";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // private constructor: stops anyone creating "new DBConnection()" from outside this class
    private DBConnection() {
    }

    // public static method: this is what makes it a Singleton — always returns the SAME connection
    public static Connection getInstance() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Database connected successfully");
            } catch (SQLException e) {
                System.out.println("Connection failed: " + e.getMessage());
            }
        }
        return connection;
    }
}