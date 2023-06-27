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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class WindowButtons extends HBox {

        public double xOffset = 0;
        public double yOffset = 0;

        public ToolBar toolBar;
        public Stage stage;

        public WindowButtons(){
            Button closeBtn = new Button();
            Button minimizeBtn = new Button();
            Button maximizeBtn = new Button();

            Image closeImage = new Image(getClass().getResourceAsStream("/images/close.png"));
            Image minimizeImage = new Image(getClass().getResourceAsStream("/images/minimize.png"));
            Image maximizeImage = new Image(getClass().getResourceAsStream("/images/maximize.png"));

            ImageView closeImageView = new ImageView(closeImage);
            closeImageView.setFitWidth(15);
            closeImageView.setFitHeight(15);
            ImageView minimizeImageView = new ImageView(minimizeImage);
            minimizeImageView.setFitWidth(15);
            minimizeImageView.setFitHeight(15);
            ImageView maximizeImageView = new ImageView(maximizeImage);
            maximizeImageView.setFitWidth(15);
            maximizeImageView.setFitHeight(15);

            closeBtn.setGraphic(closeImageView);
            minimizeBtn.setGraphic(minimizeImageView);
            maximizeBtn.setGraphic(maximizeImageView);

            closeBtn.setStyle("-fx-background-color: #091A21; -fx-text-fill: #FDC373; -fx-width: 20; -fx-height: 20; -fx-layout-x: 1040; -fx-layout-y: 1;");
            //agregarle a closeBtn una clase de css
            closeBtn.getStyleClass().add("close-button");


            //editar el tamaño de la imagen para que se vea bien

            minimizeBtn.setStyle("-fx-background-color: #091A21; -fx-text-fill: #FDC373; -fx-width: 20; -fx-height: 20; -fx-layout-x: 954; -fx-layout-y: 1;");
            maximizeBtn.setStyle("-fx-background-color: #091A21; -fx-text-fill: #FDC373; -fx-width: ; -fx-height: 20; -fx-layout-x: 1009; -fx-layout-y: 8;");

           /* Button closeBtn = new Button("X");
            Button minimizeBtn = new Button("_");
            Button maximizeBtn = new Button("⬜");*/

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
        public WindowButtons(Stage stage1, Parent root) {
            stage = stage1;

            toolBar = new ToolBar();
            toolBar.setOrientation(javafx.geometry.Orientation.HORIZONTAL);
            int height = 30;

            HBox hbox1 = new HBox();
            hbox1.setPrefHeight(height);
            hbox1.setPrefWidth(970);

            Image docturno = new Image(getClass().getResourceAsStream("/images/docturno.png"));
            ImageView docturnoView = new ImageView(docturno);
            docturnoView.setFitHeight(16);
            docturnoView.setFitWidth(104);

            /*hbox1.getChildren().add(docturnoView);*/
            //acomodar docturno en center right
            hbox1.setSpacing(10);

            hbox1.getChildren().add(docturnoView);



            toolBar.getItems().add(hbox1); //agrego docturno a encabezado
            toolBar.setPrefHeight(height);
            toolBar.setMinHeight(height);
            toolBar.setMaxHeight(height);

            toolBar.getItems().add(new WindowButtons());

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
