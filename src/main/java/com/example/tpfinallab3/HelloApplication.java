package com.example.tpfinallab3;

import com.example.tpfinallab3.controllers.LoginController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    private double xOffset = 0;
    private double yOffset = 0;


    class WindowButtons extends HBox {

        public WindowButtons() {
            Button closeBtn = new Button("X");
            Button minimizeBtn = new Button("_");
            Button maximizeBtn = new Button("⬜");

            closeBtn.setStyle("-fx-background-color: #091A21; -fx-text-fill: #FDC373; -fx-width: 20; -fx-height: 20; -fx-layout-x: 1040; -fx-layout-y: 1;");
            minimizeBtn.setStyle("-fx-background-color: #091A21; -fx-text-fill: #FDC373; -fx-width: 20; -fx-height: 20; -fx-layout-x: 954; -fx-layout-y: 1;");
            maximizeBtn.setStyle("-fx-background-color: #091A21; -fx-text-fill: #FDC373; -fx-width: ; -fx-height: 20; -fx-layout-x: 1009; -fx-layout-y: 8;");
            closeBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Platform.exit();
                }
            });

            minimizeBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Stage stage = (Stage) minimizeBtn.getScene().getWindow();
                    stage.setIconified(true);
                }
            });
            this.getChildren().addAll(minimizeBtn, maximizeBtn, closeBtn);
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        Font.loadFont(getClass().getResourceAsStream("/fonts/CinzelDecorative-Regular.ttf"), 16);
        Font.loadFont(getClass().getResourceAsStream("/fonts/NanumGothic-Bold.ttf"), 16);
        Font.loadFont(getClass().getResourceAsStream("/fonts/NanumGothic-Regular.ttf"), 16);
        Font.loadFont(getClass().getResourceAsStream("/fonts/PlayfairDisplay-VariableFont_wght.ttf"), 16);

        ToolBar toolBar = new ToolBar();
        toolBar.setOrientation(javafx.geometry.Orientation.HORIZONTAL);
        int height = 30;
        toolBar.setPrefHeight(height);
        toolBar.setMinHeight(height);
        toolBar.setMaxHeight(height);

        toolBar.getItems().add(new WindowButtons());
        toolBar.getItems().add(new Separator());
        toolBar.getItems().add(new Label("Docturno®"));

        toolBar.styleProperty().set("-fx-background-color: #091A21;");

        stage.initStyle(StageStyle.UNDECORATED);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Parent root;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);

        toolBar.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        toolBar.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });

        stage.setTitle("Docturno®");
        stage.setScene(scene);

        BorderPane borderPane = new BorderPane(root);
        borderPane.setTop(toolBar);
        stage.setScene (new Scene(borderPane));

        stage.show();
        LoginController loginController = fxmlLoader.getController();
        loginController.setStage(stage);
    }
    
    public static void main(String[] args) {
        launch();
    }
}