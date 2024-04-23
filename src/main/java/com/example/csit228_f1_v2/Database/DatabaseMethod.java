package com.example.csit228_f1_v2.Database;

import java.sql.*;

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

    public static void initDb(){
        try(Connection conn = MySQLConnection.getConnection();
        Statement statement = conn.createStatement()){
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS tblUserAccount(" +
                            "user_id INTEGER PRIMARY KEY AUTO_INCREMENT," +
                            "username TEXT UNIQUE NOT NULL," +
                            "password VARCHAR(100) NOT NULL" +
                            ");"
            );
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS tblArtifacts(" +
                            "artifact_id INTEGER PRIMARY KEY AUTO_INCREMENT," +
                            "user_id INTEGER UNIQUE," +
                            "artifact_name TEXT," +
                            "main_stat TEXT," +
                            "subStat_1 TEXT," +
                            "subStat_2 TEXT," +
                            "subStat_3 TEXT," +
                            "subStat_4 TEXT," +
                            "artifact_type TEXT," +
                            "FOREIGN KEY(user_id) REFERENCES tblUserAccount(user_id)" +
                            ");"
            );
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS tblEquipped(" +
                            "user_id INTEGER," +
                            "artifact_id INTEGER," +
                            "artifact_type TEXT," +
                            "FOREIGN KEY(user_id) REFERENCES tblUserAccount(user_id)," +
                            "FOREIGN KEY(artifact_id) REFERENCES tblArtifacts(artifact_id)" +
                            ");"
            );
        } catch (SQLException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
    }

}
