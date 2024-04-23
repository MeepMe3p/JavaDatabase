package com.example.csit228_f1_v2.Scenes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MainScene extends AnchorPane {
    public MainScene(){
        this.setPrefHeight(720);
        this.setPrefWidth(720);

        Image backgroundImage = new Image(LoginScene.class.getResource("/textures/login-bg2.jpg").toExternalForm());
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(720);
        backgroundImageView.setFitHeight(720);

        getChildren().addAll(backgroundImageView);
    }
}
