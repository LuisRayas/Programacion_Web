package com.upiicsa.app;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author Rayas Batalla Luis A.
 */
public class DatabaseConnection {
    private Connection connection = null;
	
    public DatabaseConnection() throws SQLException, ClassNotFoundException {
        final String source = "jdbc:mysql://localhost:3306/personal_notes?useSSL=false";
        final String user = "root";
        final String password = "conejos12";
		
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connection = DriverManager.getConnection(source, user, password);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
	
    public void executeNonQuery(String query, Object... parameters) throws SQLException {
        var statement = connection.prepareStatement(query);

        if (parameters != null && parameters.length > 0) {
            for (int i = 0; i < parameters.length; i++) {
                statement.setObject(i + 1, parameters[i]);
            }
        }

        statement.executeUpdate();
    }

    public ResultSet executeQuery(String query, Object... parameters) throws SQLException {
        var statement = connection.prepareStatement(query);

        if (parameters != null && parameters.length > 0) {
            for (int i = 0; i < parameters.length; i++) {
                statement.setObject(i + 1, parameters[i]);
            }
        }
        
        return statement.executeQuery();
    }

    public void disconnect() throws SQLException {
        connection.close();
    }
}
