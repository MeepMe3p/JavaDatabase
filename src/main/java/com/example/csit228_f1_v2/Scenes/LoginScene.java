package com.example.csit228_f1_v2.Scenes;

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
        BackgroundFill bg = new BackgroundFill(backgcolor.interpolate(Color.DARKRED,0.5),null,null);
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


        registerVbox.getChildren().addAll(welciome,welcome,unameField,hbPasswordField,hbButtons);


        // Set position of VBox within AnchorPane
        AnchorPane.setTopAnchor(registerVbox, 190.0);
        AnchorPane.setLeftAnchor(registerVbox, 150.0);

        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MainScene mainScene = new MainScene();
                Scene s = new Scene(mainScene);
                stage.setScene(s);
                stage.show();

                stage.show();
            }
        });

        // Add background image and VBox to LoginScene
        getChildren().addAll(backgroundImageView, registerVbox);
    }
}
