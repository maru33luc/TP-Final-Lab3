package com.example.tpfinallab3.models;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class WindowButtons extends HBox {

        public double xOffset = 0;
        public double yOffset = 0;

        public ToolBar toolBar;
        public Stage stage;

        public WindowButtons(){
            Button closeBtn = new Button("X");
            Button minimizeBtn = new Button("_");
            Button maximizeBtn = new Button("⬜");

            closeBtn.setStyle("-fx-background-color: #091A21; -fx-text-fill: #FDC373; -fx-width: 20; -fx-height: 20; -fx-layout-x: 1040; -fx-layout-y: 1;");
            minimizeBtn.setStyle("-fx-background-color: #091A21; -fx-text-fill: #FDC373; -fx-width: 20; -fx-height: 20; -fx-layout-x: 954; -fx-layout-y: 1;");
            maximizeBtn.setStyle("-fx-background-color: #091A21; -fx-text-fill: #FDC373; -fx-width: 20; -fx-height: 20; -fx-layout-x: 1009; -fx-layout-y: 8;");
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
        public WindowButtons(Stage stage1, Parent root) {
            stage = stage1;

            toolBar = new ToolBar();
            toolBar.setOrientation(javafx.geometry.Orientation.HORIZONTAL);
            int height = 30;
            toolBar.setPrefHeight(height);
            toolBar.setMinHeight(height);
            toolBar.setMaxHeight(height);

            toolBar.getItems().add(new WindowButtons());
            toolBar.getItems().add(new Separator());
            toolBar.getItems().add(new Label("Docturno®"));

            toolBar.styleProperty().set("-fx-background-color: #091A21;");
            toolBar.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            toolBar.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            });
            Scene scene = new Scene(root);
            stage.setTitle("Docturno®");
            stage.setScene(scene);

            BorderPane borderPane = new BorderPane(root);
            borderPane.setTop(toolBar);
            stage.setScene (new Scene(borderPane));
        }
}
