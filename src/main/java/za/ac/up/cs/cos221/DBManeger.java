package za.ac.up.cs.cos221;

import java.sql.*;


public class DBManeger {
    private static String driver = "jdbc:mariadb";
    private static String host = "localhost";
    private static int port = 3306;
    private static String database = "u20473509_sakila";
    private static String username = "admin";
    private static String password = "password";

    private Connection connection;
    private Statement statement;

    public DBManeger() {
        String url = new StringBuilder()
                .append(driver).append("://")
                .append(host).append(":").append(port).append("/")
                .append(database)
                .toString();

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            return statement.executeQuery(query);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }
}
