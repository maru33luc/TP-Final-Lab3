package com.example.tpfinallab3;

import com.example.tpfinallab3.controllers.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        Font.loadFont(getClass().getResourceAsStream("/fonts/CinzelDecorative-Regular.ttf"), 16);
        Font.loadFont(getClass().getResourceAsStream("/fonts/NanumGothic-Bold.ttf"), 16);
        Font.loadFont(getClass().getResourceAsStream("/fonts/NanumGothic-Regular.ttf"), 16);
        Font.loadFont(getClass().getResourceAsStream("/fonts/PlayfairDisplay-VariableFont_wght.ttf"), 16);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Parent root;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        stage.setTitle("Docturno®");
        stage.setScene(scene);
        stage.show();
        LoginController loginController = fxmlLoader.getController();
        loginController.setStage(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}