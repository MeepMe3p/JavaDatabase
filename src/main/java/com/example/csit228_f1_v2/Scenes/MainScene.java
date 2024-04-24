package com.example.csit228_f1_v2.Scenes;

import com.example.csit228_f1_v2.ArtifactSystem.Artifact;
import com.example.csit228_f1_v2.Database.DatabaseMethod;
import com.example.csit228_f1_v2.Database.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
import java.util.Objects;
import java.util.Random;

import static com.example.csit228_f1_v2.Database.DatabaseMethod.currentlyLoggedIn;

public class MainScene extends AnchorPane {
    public static int flowerEquipped;
    public static int featherEquipped;
    public static int gobletEquipped;
    public static int sandsEquipped;
    public static int circletEquipped;
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
//        player.setVolume(100);
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
        btnGetArtifact.setTranslateX(175);
        btnGetArtifact.setTranslateY(25);
        btnGetArtifact.setPrefWidth(100);
        btnGetArtifact.setPrefHeight(50);

        Button btnEquip = new Button("Equip Artifacts");
        btnEquip.setTranslateX(50);
        btnEquip.setTranslateY(25);
        btnEquip.setPrefHeight(50);
        btnEquip.setPrefWidth(100);

        Button btnLogout = new Button("Logout");
        btnLogout.setTranslateX(300);
        btnLogout.setTranslateY(25);
        btnEquip.setPrefHeight(50);
        btnEquip.setPrefWidth(100);
        btnLogout.setPrefWidth(100);
        btnLogout.setPrefHeight(50);
        btnLogout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                player.stop();
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
        hbRollArtifacts.getChildren().addAll(vbStats);
        hbRollArtifacts.setTranslateX(620);
        hbRollArtifacts.setTranslateY(150);
        hbRollArtifacts.setPrefWidth(300);
        hbRollArtifacts.setPrefHeight(300);
        hbRollArtifacts.setVisible(false);

//        Image backgroundImage = new Image(LoginScene.class.getResource("/textures/crimon-flower.png").toExternalForm());
//        ImageView backgroundImageView = new ImageView();



        User user = User.getInstance();

        Button btnSave = new Button("Update random artifacts");
        Button btnDelete = new Button("Delete All Random Artifacts");

                VBox vbEquipArti = new VBox();
        vbEquipArti.setTranslateX(530);
        vbEquipArti.setTranslateY(20);
        vbEquipArti.setPrefWidth(700);
        vbEquipArti.setPrefHeight(500);
        vbEquipArti.setVisible(false);
        vbEquipArti.setBackground(bg2);

        VBox vbDelete = new VBox();
        vbDelete.setTranslateX(530);
        vbDelete.setTranslateY(20);
        vbDelete.setPrefWidth(700);
        vbDelete.setPrefHeight(500);
        vbDelete.setVisible(false);
//        vbEquipArti.setBackground(bg2);


        Button btnShowDelete = new Button("Delete Artifacts");
        btnShowDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                vbDelete.setVisible(true);
                vbStats.setVisible(false);
                vbEquipArti.setVisible(false);
            }
        });

        vbDelete.getChildren().add(btnDelete);




        btnEquip.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                HBox hbFlower = new HBox();
                HBox hbFeather = new HBox();
                HBox hbSands = new HBox();
                HBox hbGoblet = new HBox();
                HBox hbCirclet = new HBox();

                hbFlower = createBox(currentlyLoggedIn,"/textures/crimon-flower.png","FLOWER");
                hbFeather = createBox(currentlyLoggedIn,"/textures/crimson-feather.jpg","FEATHER");
                hbSands = createBox(currentlyLoggedIn,"/textures/crimson-sands.jpg","SANDS");
                hbGoblet = createBox(currentlyLoggedIn,"/textures/crimon-goblet.jpg","GOBLET");
                hbCirclet = createBox(currentlyLoggedIn,"/textures/crimson-circlet.jpg","CIRCLET");
                hbRollArtifacts.setVisible(false);
                vbEquipArti.setVisible(true);
                vbEquipArti.getChildren().clear();
                vbEquipArti.getChildren().addAll(hbFlower,hbFeather,hbSands,hbGoblet,hbCirclet,btnSave);


            }
        });
        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Random randy = new Random();
                int n = randy.nextInt(5);
                switch (n){
                    case 0:
                        DatabaseMethod.deleteSelected("FLOWER");
                        break;
                    case 1:
                        DatabaseMethod.deleteSelected("FEATHER");
                        break;
                    case 2:
                        DatabaseMethod.deleteSelected("GOBLET");
                        break;
                    case 3:
                        DatabaseMethod.deleteSelected("SANDS");
                        break;
                    case 4:
                        DatabaseMethod.deleteSelected("CIRCLET");
                        break;
                }


            }
        });
        btnGetArtifact.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                vbEquipArti.setVisible(false);
                hbRollArtifacts.setVisible(true);

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
                vbStats.getChildren().clear();
                vbStats.getChildren().addAll(backgroundImageView,lblName,lblType,lblMain,lblsub1,lblsub2,lblsub3,lblsub4,/*btnRollAgain,*/btnClose);


            }
        });
        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Random randy = new Random();
                int n = randy.nextInt(5);
                switch (n){
                    case 0:
                        DatabaseMethod.updateArtifacts("FLOWER");
                        break;
                    case 1:
                        DatabaseMethod.updateArtifacts("FEATHER");
                        break;
                    case 2:
                        DatabaseMethod.updateArtifacts("GOBLET");
                        break;
                    case 3:
                        DatabaseMethod.updateArtifacts("SANDS");
                        break;
                    case 4:
                        DatabaseMethod.updateArtifacts("CIRCLET");
                        break;
                }
            }
        });
        btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                hbRollArtifacts.setVisible(false);
            }
        });

        getChildren().addAll(mv,btnGetArtifact,btnEquip,btnLogout,hbRollArtifacts,vbEquipArti,vbDelete,btnShowDelete);
    }

    public HBox createBox(int user, String imgURl,String type){
        HBox box = new HBox();
        Image img = new Image(LoginScene.class.getResource(imgURl).toExternalForm());
        ImageView imgView = new ImageView(img);
        imgView.setFitHeight(128);
        imgView.setFitWidth(128);
        ComboBox<String> cb = new ComboBox<>();
        cb.setItems(DatabaseMethod.getArtifacts(user,type));
        cb.setMaxWidth(50);
        Label lblType = new Label();
        Label lblName = new Label();
        Label lblMain = new Label();
        Label lblSub1 = new Label();
        Label lblSub2 = new Label();
        Label lblSub3 = new Label();
        Label lblSub4 = new Label();
        Label lblArtifact_id = new Label();


        cb.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String res = cb.getValue();
                System.out.println(res);
                if(res != null && !res.isEmpty()){
                    String[] parts = res.split("\\|");
//                    StringBuilder sb = new StringBuilder();
                    System.out.println(parts[0] + " <-- NOW -->"+parts.length);
                    lblName.setText(parts[0]);
                    lblType.setText(parts[1]);
                    lblMain.setText(parts[2]);
                    lblSub1.setText(parts[3]);
                    lblSub2.setText(parts[4]);
                    lblSub3.setText(parts[5]);
                    lblSub4.setText(parts[6]);
                    lblArtifact_id.setText(parts[7]);

                    lblName.setTextFill(Color.WHITE);
                    lblType.setTextFill(Color.WHITE);
                    lblMain.setTextFill(Color.WHITE);
                    lblSub1.setTextFill(Color.WHITE);
                    lblSub2.setTextFill(Color.WHITE);
                    lblSub3.setTextFill(Color.WHITE);
                    lblSub4.setTextFill(Color.WHITE);

                }
            }
        });



        box.getChildren().addAll(imgView,cb,lblType,lblName,lblMain,lblSub1,lblSub2,lblSub3,lblSub4);
        return box;
    }
}
