package com.example.csit228_f1_v2.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseMethod {
    public static void registerUser(String username, String password){
        try (Connection conn = MySQLConnection.getConnection()){
            String query = "INSERT INTO users(name,email) VALUES (?,?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1,username);
            statement.setString(2,password);

            statement.executeUpdate();
            System.out.println("Successfully inserted");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean logIn(String username, String password) {
        try (Connection con = MySQLConnection.getConnection();
             PreparedStatement statement = con.prepareStatement("" +
                     "SELECT * FROM users WHERE username = ? AND email = ?")) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.getResultSet();

//            statement.executeQuery().beforeFirst();
//            return

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

}
