package com.example.csit228_f1_v2.Scenes;

import com.example.csit228_f1_v2.Database.DatabaseMethod;
import com.example.csit228_f1_v2.Database.MySQLConnection;
import com.example.csit228_f1_v2.Database.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.*;
import java.util.Objects;

public class LoginScene extends AnchorPane {
    public LoginScene(Stage stage){
        this.setMaxHeight(720);
        this.setMaxWidth(720);

        // Load background image
        Image backgroundImage = new Image(LoginScene.class.getResource("/textures/login-bg2.jpg").toExternalForm());
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(720);
        backgroundImageView.setFitHeight(720);

        // Create VBox for login UI elements
        VBox registerVbox = new VBox();
        registerVbox.setPadding(new Insets(20));
        registerVbox.setSpacing(10);
        Color backgcolor = new Color(1,0.0,0.0,0.5);
        BackgroundFill bg = new BackgroundFill(backgcolor.interpolate(Color.DARKRED,0.1),null,null);
        Background bg2 = new Background(bg);


        registerVbox.setPrefWidth(300);
        registerVbox.setPrefHeight(250);
        registerVbox.setBackground(bg2);

        Label welciome = new Label("WELCOME AND HELP ME");
        welciome.setFont(new Font(20));
        welciome.setTextFill(Color.WHITE);
        Label welcome = new Label(" BUILD MY HUTAO");
        welcome.setTextFill(Color.WHITE);
        welcome.setFont(new Font(20));

        Label username = new Label();
        TextField tfUsername = new TextField();
        tfUsername.setPrefWidth(180);
        username.setFont(new Font(15));
        tfUsername.setPromptText("Enter your username");
        username.setText("Username: ");
        username.setTextFill(Color.WHITE);
        HBox unameField = new HBox();
        unameField.getChildren().addAll(username,tfUsername);

        Label password = new Label();
        password.setText("Password: ");
        TextField tfPassword = new TextField();
        tfPassword.setPromptText("Enter Password");
        tfPassword.setPrefWidth(180);
        password.setFont(new Font(15));
        password.setTextFill(Color.WHITE);
        HBox hbPasswordField = new HBox();
        hbPasswordField.getChildren().addAll(password,tfPassword);

        Button btnLogin = new Button("Login");
        Button btnRegister = new Button("Register");
        HBox hbButtons = new HBox();
        hbButtons.getChildren().addAll(btnLogin,btnRegister);
        Label lblBg = new Label("Login again if no background after login :(");
        lblBg.setTextFill(Color.ORANGE);
        Label lblWarning = new Label();
        lblWarning.setVisible(false);
        lblWarning.setTextFill(Color.YELLOW);




        registerVbox.getChildren().addAll(welciome,welcome,unameField,hbPasswordField,hbButtons,lblBg,lblWarning);


        AnchorPane.setTopAnchor(registerVbox, 190.0);
        AnchorPane.setLeftAnchor(registerVbox, 150.0);

        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int i = DatabaseMethod.logIn(tfUsername.getText(),tfPassword.getText());
                if(i == -1){
                    lblWarning.setText("Incorrect Username or Password");
                    lblWarning.setVisible(true);
                }else{
                    User user = User.getInstance();
                    user.setUsername(username.getText());
                    user.setUserId(i);
                    MainScene mainScene = new MainScene(stage);
                    Scene s = new Scene(mainScene);
                    stage.setScene(s);
                    stage.setX(100);
                    stage.setY(25);
                    stage.show();
                }


            }
        });
        btnRegister.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    if(Objects.equals(tfUsername.getText(), "")){
                        lblWarning.setText("You must enter a username");
                        lblWarning.setVisible(true);
                    }else if(Objects.equals(tfPassword.getText(),"")){
                        lblWarning.setText("You must enter a password");
                        lblWarning.setVisible(true);
                    }
                    else {
                        DatabaseMethod.registerUser(tfUsername.getText(), tfPassword.getText());
                        tfUsername.setText("");
                        tfPassword.setText("");
                    }
                } catch (SQLIntegrityConstraintViolationException e) {
                    lblWarning.setText("Username already exists");
                    lblWarning.setVisible(true);
                    tfUsername.setText("");
                    tfPassword.setText("");
                }
            }
        });

        // Add background image and VBox to LoginScene
        getChildren().addAll(backgroundImageView, registerVbox);
    }
}
