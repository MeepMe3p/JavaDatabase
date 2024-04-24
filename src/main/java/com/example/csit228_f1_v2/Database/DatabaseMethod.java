package com.example.csit228_f1_v2.Database;

import java.sql.*;

public class DatabaseMethod {
    public static int currentlyLoggedIn;
    public static void registerUser(String username, String password) throws SQLIntegrityConstraintViolationException {
        try(Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(
                "INSERT INTO tbluseraccount (username,password) VALUES (?,?)")
        ){
            statement.setString(1,username);
            statement.setString(2,password);
            statement.executeUpdate();
        } catch(SQLIntegrityConstraintViolationException e){
            throw new SQLIntegrityConstraintViolationException();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertArtifact(String name, String main, String sub1, String sub2, String sub3, String sub4, String type){
        try(Connection conn = MySQLConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(
                    "INSERT INTO tblartifacts (user_id, artifact_name, main_stat, subStat_1, subStat_2, subStat_3, subStat_4, artifact_type) VALUES (?,?,?,?,?,?,?,?)"
            )){
                statement.setInt(1,currentlyLoggedIn);
                statement.setString(2,name);
                statement.setString(3,main);
                statement.setString(4,sub1);
                statement.setString(5,sub2);
                statement.setString(6,sub3);
                statement.setString(7,sub4);
                statement.setString(8,type);

                statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static int logIn(String username, String password) {
        try(Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(
                "SELECT user_id FROM tbluseraccount WHERE username = ? AND password = ?")){
            statement.setString(1,username);
            statement.setString(2,password);

            ResultSet rs = statement.executeQuery();

            System.out.println("went here");
            if(rs.next()) {
                System.out.println(rs.getString(1));

                if (rs.getInt("user_id") != 0) {
                    System.out.println("found");
                    System.out.println("ID: " + rs.getInt("user_id") + " Username: " + username + " Password: " + password);
                    currentlyLoggedIn = rs.getInt("user_id");
                    return rs.getInt("user_id");
                } else {
                    System.out.println("Not found");
                    return -1;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
//            e.printStackTrace();
        }
        return -1;
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
                            "user_id INTEGER," +
                            "artifact_name TEXT," +
                            "main_stat TEXT," +
                            "subStat_1 TEXT," +
                            "subStat_2 TEXT," +
                            "subStat_3 TEXT," +
                            "subStat_4 TEXT," +
                            "artifact_type TEXT," +
                            "FOREIGN KEY(user_id) REFERENCES tblUserAccount(user_id) ON DELETE CASCADE"  +
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
