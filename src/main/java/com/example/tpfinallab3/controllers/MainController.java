package com.example.tpfinallab3.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    private Stage primaryStage;

    public MainController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void start() {
        showLoginView();
    }

    public void showLoginView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("views/LoginView.fxml"));
            Parent root = loader.load();
            LoginController loginController = loader.getController();
            loginController.setMainController(this);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Clínica - Inicio de Sesión");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showClinicView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("views/ClinicView.fxml"));
            Parent root = loader.load();
            ClinicController clinicController = loader.getController();
            clinicController.setMainController(this);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Clínica - Vista Principal");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Otros métodos para mostrar diferentes vistas

    public static void main(String[] args) {
        launch(args);
    }

    public static void launch(String[] args) {
        Application.launch(args);
    }
}
