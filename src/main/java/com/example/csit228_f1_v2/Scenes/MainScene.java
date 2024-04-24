package com.example.csit228_f1_v2.Scenes;

import com.example.csit228_f1_v2.ArtifactSystem.Artifact;
import com.example.csit228_f1_v2.Database.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.util.Random;

public class MainScene extends AnchorPane {
    public MainScene(Stage stage){
        this.setPrefHeight(720);
        this.setPrefWidth(1280);

//        Image backgroundImage = new Image(LoginScene.class.getResource("/textures/mainscene-bg.jpg").toExternalForm());
//        ImageView backgroundImageView = new ImageView(backgroundImage);
//        backgroundImageView.setFitWidth(1280);
//        backgroundImageView.setFitHeight(720);
        Color backgcolor = new Color(1,0.0,0.0,0.5);
        BackgroundFill bg = new BackgroundFill(backgcolor.interpolate(Color.WHITE,0.1),null,null);
        Background bg2 = new Background(bg);

//        File file = new File("src/main/resources/textures/hutao_idle.mp4");
        File file = new File("src/main/resources/textures/main-scene.mp4");
        Media media = new Media(file.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        MediaView mv = new MediaView(player);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.play();
//        System.out.println("nirun");

        mv.setFitWidth(1280);
        mv.setFitHeight(720);
//        AnchorPane.setLeftAnchor(mv, 0.0);

        VBox warning = new VBox();
        Label war = new Label("Login again if no background :(");
        Button btnWarning = new Button("Close");
        warning.setTranslateX(1280/2);
        warning.setTranslateY(720/2);
        warning.setVisible(true);
        btnWarning.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                war.setVisible(false);
            }
        });

        Button btnGetArtifact = new Button("Get Artifact");
        btnGetArtifact.setTranslateX(1280-150);
        btnGetArtifact.setTranslateY(50);
        btnGetArtifact.setPrefWidth(100);
        btnGetArtifact.setPrefHeight(50);

        Button btnEquip = new Button("Equip Artifacts");
        btnEquip.setTranslateX(1280-300);
        btnEquip.setTranslateY(50);
        btnEquip.setPrefHeight(50);
        btnEquip.setPrefWidth(100);

        Button btnLogout = new Button("Logout");
        btnLogout.setTranslateX(300);
        btnLogout.setTranslateY(50);
        btnEquip.setPrefHeight(50);
        btnEquip.setPrefWidth(100);
        btnLogout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                User.getInstance().setUserId(0);
                User.getInstance().setUsername("");
                LoginScene ls = new LoginScene(stage);
                Scene sc = new Scene(ls);
                stage.setScene(sc);
                stage.show();
            }
        });
        HBox hbRollArtifacts = new HBox();
        VBox vbStats = new VBox();
        Label lblName = new Label();
        Label lblType = new Label();
        Label lblMain = new Label();
        Label lblsub1 = new Label();
        Label lblsub2 = new Label();
        Label lblsub3 = new Label();
        Label lblsub4 = new Label();
        lblsub1.setFont(new Font(15));
        lblsub2.setFont(new Font(15));
        lblsub3.setFont(new Font(15));
        lblsub4.setFont(new Font(15));
        hbRollArtifacts.setPrefHeight(50);
        hbRollArtifacts.setPrefWidth(50);

        vbStats.setPrefHeight(50);
        vbStats.setPrefWidth(30);
        vbStats.setPrefHeight(300);
        vbStats.setPrefWidth(300);
        vbStats.setAlignment(Pos.CENTER);
        vbStats.setPadding(new Insets(10));


//        Image backgroundImage = new Image(LoginScene.class.getResource("/textures/crimon-flower.png").toExternalForm());
//        ImageView backgroundImageView = new ImageView(backgroundImage);
//        backgroundImageView.setFitWidth(256);
//        backgroundImageView.setFitHeight(256);

        Button btnClose= new Button("Close");
        Button btnRollAgain = new Button("Roll Again");
        hbRollArtifacts.setBackground(bg2);
//        vbStats.setTranslateY;
        hbRollArtifacts.getChildren().addAll(vbStats,btnRollAgain,btnClose);
        hbRollArtifacts.setTranslateX(1280-400);
        hbRollArtifacts.setTranslateY(150);
        hbRollArtifacts.setPrefWidth(300);
        hbRollArtifacts.setPrefHeight(300);
        hbRollArtifacts.setVisible(false);

        btnRollAgain.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                Artifacts artifacts = new Artifacts("Witch's Heart Flames","GOBLET");
//                artifacts.pull();
                String name,main,sub1,sub2,sub3,sub4;
                Random randy = new Random();
                int randType = randy.nextInt(5);
                Artifact artifact = new Artifact(randType);
                System.out.println(randType);
                Image backgroundImage;
                ImageView backgroundImageView = new ImageView();
                artifact.pull();
                switch (randType){
                    case 0:

                        backgroundImage = new Image(LoginScene.class.getResource("/textures/crimon-flower.png").toExternalForm());
                        backgroundImageView = new ImageView(backgroundImage);
                        backgroundImageView.setFitWidth(256);
                        backgroundImageView.setFitHeight(256);
                        lblMain.setText(artifact.getMainStat());
                        lblsub1.setText(artifact.getSub1());
                        lblsub2.setText(artifact.getSub2());
                        lblsub3.setText(artifact.getSub3());
                        lblsub4.setText(artifact.getSub4());
                        lblName.setText(artifact.getName());
                        lblType.setText(artifact.getArt_type());

                        break;
                    case 1:
                        backgroundImage = new Image(LoginScene.class.getResource("/textures/crimson-feather.jpg").toExternalForm());
                        backgroundImageView = new ImageView(backgroundImage);
                        backgroundImageView.setFitWidth(256);
                        backgroundImageView.setFitHeight(256);
                        lblMain.setText(artifact.getMainStat());
                        lblsub1.setText(artifact.getSub1());
                        lblsub2.setText(artifact.getSub2());
                        lblsub3.setText(artifact.getSub3());
                        lblsub4.setText(artifact.getSub4());
                        lblName.setText(artifact.getName());
                        lblType.setText(artifact.getArt_type());
                        break;
                    case 2:
                        backgroundImage = new Image(LoginScene.class.getResource("/textures/crimson-sands.jpg").toExternalForm());
                        backgroundImageView = new ImageView(backgroundImage);
                        backgroundImageView.setFitWidth(256);
                        backgroundImageView.setFitHeight(256);
                        lblMain.setText(artifact.getMainStat());
                        lblsub1.setText(artifact.getSub1());
                        lblsub2.setText(artifact.getSub2());
                        lblsub3.setText(artifact.getSub3());
                        lblsub4.setText(artifact.getSub4());
                        lblName.setText(artifact.getName());
                        lblType.setText(artifact.getArt_type());
                        break;
                    case 3:
                        backgroundImage = new Image(LoginScene.class.getResource("/textures/crimon-goblet.jpg").toExternalForm());
                        backgroundImageView = new ImageView(backgroundImage);
                        backgroundImageView.setFitWidth(256);
                        backgroundImageView.setFitHeight(256);
                        lblMain.setText(artifact.getMainStat());
                        lblsub1.setText(artifact.getSub1());
                        lblsub2.setText(artifact.getSub2());
                        lblsub3.setText(artifact.getSub3());
                        lblsub4.setText(artifact.getSub4());
                        lblName.setText(artifact.getName());
                        lblType.setText(artifact.getArt_type());
                        break;
                    case 4:
                        backgroundImage = new Image(LoginScene.class.getResource("/textures/crimson-circlet.jpg").toExternalForm());
                        backgroundImageView = new ImageView(backgroundImage);
                        backgroundImageView.setFitWidth(256);
                        backgroundImageView.setFitHeight(256);
                        lblMain.setText(artifact.getMainStat());
                        lblsub1.setText(artifact.getSub1());
                        lblsub2.setText(artifact.getSub2());
                        lblsub3.setText(artifact.getSub3());
                        lblsub4.setText(artifact.getSub4());
                        lblName.setText(artifact.getName());
                        lblType.setText(artifact.getArt_type());
                        break;
                }
//                vbStats.getChildren().remove(0);
//                vbStats.getChildren().removeAll(backgroundImageView);

                vbStats.getChildren().addAll(backgroundImageView,lblName,lblType,lblMain,lblsub1,lblsub2,lblsub3,lblsub4);


            }
        });

        btnGetArtifact.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                Artifacts artifacts = new Artifacts("Witch's Heart Flames","GOBLET");
//                artifacts.pull();
                hbRollArtifacts.setVisible(true);

//                String name,main,sub1,sub2,sub3,sub4;
//                Random randy = new Random();
//                int randType = randy.nextInt(5);
//                Artifact artifact = new Artifact(randType);
//                System.out.println(randType);
//                Image backgroundImage;
//                ImageView backgroundImageView = new ImageView();
//                artifact.pull();
//                switch (randType){
//                    case 0:
//
//                        backgroundImage = new Image(LoginScene.class.getResource("/textures/crimon-flower.png").toExternalForm());
//                        backgroundImageView = new ImageView(backgroundImage);
//                        backgroundImageView.setFitWidth(256);
//                        backgroundImageView.setFitHeight(256);
//                        lblMain.setText(artifact.getMainStat());
//                        lblsub1.setText(artifact.getSub1());
//                        lblsub2.setText(artifact.getSub2());
//                        lblsub3.setText(artifact.getSub3());
//                        lblsub4.setText(artifact.getSub4());
//                        lblName.setText(artifact.getName());
//                        lblType.setText(artifact.getArt_type());
//
//                        break;
//                    case 1:
//                        backgroundImage = new Image(LoginScene.class.getResource("/textures/crimson-feather.jpg").toExternalForm());
//                        backgroundImageView = new ImageView(backgroundImage);
//                        backgroundImageView.setFitWidth(256);
//                        backgroundImageView.setFitHeight(256);
//                        lblMain.setText(artifact.getMainStat());
//                        lblsub1.setText(artifact.getSub1());
//                        lblsub2.setText(artifact.getSub2());
//                        lblsub3.setText(artifact.getSub3());
//                        lblsub4.setText(artifact.getSub4());
//                        lblName.setText(artifact.getName());
//                        lblType.setText(artifact.getArt_type());
//                        break;
//                    case 2:
//                        backgroundImage = new Image(LoginScene.class.getResource("/textures/crimson-sands.jpg").toExternalForm());
//                        backgroundImageView = new ImageView(backgroundImage);
//                        backgroundImageView.setFitWidth(256);
//                        backgroundImageView.setFitHeight(256);
//                        lblMain.setText(artifact.getMainStat());
//                        lblsub1.setText(artifact.getSub1());
//                        lblsub2.setText(artifact.getSub2());
//                        lblsub3.setText(artifact.getSub3());
//                        lblsub4.setText(artifact.getSub4());
//                        lblName.setText(artifact.getName());
//                        lblType.setText(artifact.getArt_type());
//                        break;
//                    case 3:
//                        backgroundImage = new Image(LoginScene.class.getResource("/textures/crimon-goblet.jpg").toExternalForm());
//                        backgroundImageView = new ImageView(backgroundImage);
//                        backgroundImageView.setFitWidth(256);
//                        backgroundImageView.setFitHeight(256);
//                        lblMain.setText(artifact.getMainStat());
//                        lblsub1.setText(artifact.getSub1());
//                        lblsub2.setText(artifact.getSub2());
//                        lblsub3.setText(artifact.getSub3());
//                        lblsub4.setText(artifact.getSub4());
//                        lblName.setText(artifact.getName());
//                        lblType.setText(artifact.getArt_type());
//                        break;
//                    case 4:
//                        backgroundImage = new Image(LoginScene.class.getResource("/textures/crimson-circlet.jpg").toExternalForm());
//                        backgroundImageView = new ImageView(backgroundImage);
//                        backgroundImageView.setFitWidth(256);
//                        backgroundImageView.setFitHeight(256);
//                        lblMain.setText(artifact.getMainStat());
//                        lblsub1.setText(artifact.getSub1());
//                        lblsub2.setText(artifact.getSub2());
//                        lblsub3.setText(artifact.getSub3());
//                        lblsub4.setText(artifact.getSub4());
//                        lblName.setText(artifact.getName());
//                        lblType.setText(artifact.getArt_type());
//                        break;
//                }
//                vbStats.getChildren().removeAll(backgroundImageView);
//                vbStats.getChildren().addAll(backgroundImageView,lblName,lblType,lblMain,lblsub1,lblsub2,lblsub3,lblsub4,btnRollAgain,btnClose);


            }
        });
        btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                hbRollArtifacts.setVisible(false);

            }
        });

//        vbStats.getChildren().removeAll(backroundImageView);
//        vbStats.getChildren().addAll(backgroundImageView,lblName,lblType,lblMain,lblsub1,lblsub2,lblsub3,lblsub4,btnRollAgain,btnClose);

        getChildren().addAll(mv,btnGetArtifact,btnEquip,btnLogout,hbRollArtifacts);
    }
}
