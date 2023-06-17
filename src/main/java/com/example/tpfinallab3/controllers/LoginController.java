package com.example.tpfinallab3.controllers;

import com.example.tpfinallab3.security.AuthenticationService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private AuthenticationService authService;

    public LoginController() {
        authService = AuthenticationService.getInstance();
    }

    @FXML
    private void initialize() {
        // Configurar el controlador al inicializar la vista
    }

    @FXML
    private void handleLoginButton() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (authService.autenticarUsuario(username, password)) {
            // Autenticación exitosa
            // Realizar acciones después del inicio de sesión (navegar a otra vista, etc.)
            showSuccessAlert("Inicio de sesión exitoso");
        } else {
            // Autenticación fallida
            // Mostrar mensaje de error en la vista
            showErrorAlert("Nombre de usuario o contraseña incorrectos");
        }
    }

    private void showSuccessAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Éxito");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void setMainController(MainController mainController) {
        // Configurar el controlador principal

    }

    // Otros métodos y acciones relacionados con la interfaz de usuario
}
