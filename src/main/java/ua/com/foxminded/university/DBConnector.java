package ua.com.foxminded.university;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/university";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456789";

    private Connection connection = null;

    public DBConnector() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection OK");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    public void close() {
        try {
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}