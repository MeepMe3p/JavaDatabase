package com.example.csit228_f1_v2;

import com.example.csit228_f1_v2.Database.DatabaseMethod;
import com.example.csit228_f1_v2.Scenes.LoginScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 720, 720);

        stage.setTitle("Build my Waifu!");
        LoginScene login = new LoginScene(stage) ;
        Scene scene = new Scene(login,600,600);
        stage.setScene(scene);
        stage.show();
//
//        GridPane grid = new GridPane();
//        grid.setAlignment(Pos.CENTER);
//        Text txtWelcome = new Text("Welcome to CIT");
//        txtWelcome.setFont(Font.font("Chiller", FontWeight.EXTRA_BOLD, 69));
//        txtWelcome.setFill(Color.RED);
////        grid.setAlignment();
//        grid.setPadding(new Insets(20));
////        grid.
//        txtWelcome.setTextAlignment(TextAlignment.CENTER);
//        grid.add(txtWelcome, 0, 0, 3, 1);
//
//        Label lbUsername = new Label("Username: ");
//        lbUsername.setTextFill(Color.LIGHTSKYBLUE);
//        lbUsername.setFont(Font.font(30));
//        grid.add(lbUsername, 0, 1);
//
//        TextField tfUsername = new TextField();
//        grid.add(tfUsername, 1, 1);
//        tfUsername.setFont(Font.font(30));
////        tfUsername.setMaxWidth(150);
//
//        Label lbPassword = new Label("Password");
//        lbPassword.setFont(Font.font(30));
//        lbPassword.setTextFill(Color.CHARTREUSE);
//        grid.add(lbPassword, 0, 2);
//
//        PasswordField pfPassword = new PasswordField();
//        pfPassword.setFont(Font.font(30));
//        grid.add(pfPassword, 1, 2);
//
//        TextField tmpPassword = new TextField(pfPassword.getText());
//        tmpPassword.setFont(Font.font(30));
//        grid.add(tmpPassword, 1, 2);
//        tmpPassword.setVisible(false);
//
//        ToggleButton btnShow = new ToggleButton("( )");
////        btnShow.setOnAction(new EventHandler<ActionEvent>() {
////            @Override
////            public void handle(ActionEvent actionEvent) {
////                if (btnShow.isSelected()) {
////                    tmpPassword.setText(pfPassword.getText());
////                    tmpPassword.setVisible(true);
////                } else {
////                    tmpPassword.setVisible(false);
////                    pfPassword.setText(tmpPassword.getText());
////                }
////            }
////        });
//        btnShow.setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                tmpPassword.setText(pfPassword.getText());
//                tmpPassword.setVisible(true);
//            }
//        });
//
//        EventHandler<MouseEvent> release = new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                tmpPassword.setVisible(false);
//                pfPassword.setText(tmpPassword.getText());
//
//            }
//        };
//
//        btnShow.setOnMouseReleased(release);
//        btnShow.setOnMouseExited(release);
//        grid.add(btnShow, 2,2);
//
//        Button btnLogin = new Button("Log In");
//        Button btnRegister = new Button("Register");
//
//        btnLogin.setFont(Font.font(40));
//        btnRegister.setFont(Font.font(40));
//        grid.add(btnRegister,0,8,3,3);
//        grid.add(btnLogin, 0, 3, 2, 1);
//
//        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("Hello");
//                try {
//                    Parent p = FXMLLoader.load(getClass().getResource("homepage.fxml"));
//
//                    Scene s = new Scene(p);
//                    stage.setScene(s);
//                    stage.show();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        btnRegister.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("Hello");
//                try {
//                    Parent p = FXMLLoader.load(getClass().getResource("homepage.fxml"));
//                    String uname = tfUsername.getText();
//                    String pass = pfPassword.getText();
//                    DatabaseMethod.registerUser(uname,pass);
//                    Scene s = new Scene(p);
//                    stage.setScene(s);
//                    stage.show();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        Scene scene = new Scene(grid, 700, 500, Color.BLACK);
//        stage.setScene(scene);
//        scene.setFill(Color.CORNFLOWERBLUE);
//        stage.show();
//        txtWelcome.minWidth(grid.getWidth());
    }

    public static void main(String[] args) {
//        MySQLConnection.getConnection();
        DatabaseMethod.initDb();
        launch();
    }
}