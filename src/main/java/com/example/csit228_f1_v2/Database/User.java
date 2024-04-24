package com.example.csit228_f1_v2.Database;

public class User {
    private static User instance = null;
    private int userId;
    public String username;

    private User(){
        this.userId = 0;
        this.username = "";
    }

    public static User getInstance() {
        if(instance == null){
            return new User();
        }else{
             return instance;
        }
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
