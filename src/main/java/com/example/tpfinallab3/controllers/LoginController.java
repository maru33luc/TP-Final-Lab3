package com.example.tpfinallab3.controllers;

import com.example.tpfinallab3.models.Autenticable;
import com.example.tpfinallab3.security.AuthenticationService;
import com.example.tpfinallab3.security.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    private Stage stage;

    @FXML
    private AnchorPane barraDeTituloPanel;

    @FXML
    private ImageView closeButton;

    @FXML
    private Button handleLoginButton;

    @FXML
    private ImageView hidePasswordButton;

    @FXML
    private AnchorPane loginField;

    @FXML
    private BorderPane loginPanel;

    @FXML
    private Label loginRegistroLabel;

    @FXML
    private Separator loginSeparator;

    @FXML
    private ImageView maximizeButton;

    @FXML
    private ImageView minimizeButton;

    @FXML
    private Hyperlink olvidoPasswordLink;

    @FXML
    private Hyperlink olvidoUsuarioLink;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField plainPasswordField;

    @FXML
    private Label passwordLabel;

    @FXML
    private ImageView showPasswordButton;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField usernameField;

    @FXML
    private Label usuarioLabel;

    @FXML
    private Label welcomeLabel;

    private AuthenticationService authService;

    public LoginController() {
        authService = AuthenticationService.getInstance();
    }

    @FXML
    private void initialize() {
        // Configurar el controlador al inicializar la vista
    }

    @FXML
    private void clickLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (SessionManager.getInstance().iniciarSesion(username, password)) {
            // Autenticación exitosa
            // Realizar acciones después del inicio de sesión (navegar a otra vista, etc.)

            showSuccessAlert("Inicio de sesión exitoso");

            Autenticable usuarioAutenticado = SessionManager.getInstance().getEntidadLogueada();
            System.out.println("Bienvenido " + usuarioAutenticado.getNombre() + " " + usuarioAutenticado.getApellido()+ "!");

            // pasar a la ventana de paciente

            Stage stage = (Stage) handleLoginButton.getScene().getWindow();
            stage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/com/example/tpfinallab3/paciente-view.fxml"));
            Parent root;
            try {
                root = fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            PacienteViewController pacienteViewController = fxmlLoader.getController();
            pacienteViewController.setMainController(this);
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();


        } else {
            // Autenticación fallida
            // Mostrar mensaje de error en la vista
            showErrorAlert("Nombre de usuario o contraseña incorrectos");
        }
    }

    @FXML
    private void validarUsuario (KeyEvent event) {
        String username = usernameField.getText();
        if (username.isEmpty()) {
            event.consume();
            //showErrorAlert("El campo de usuario no puede estar vacío");
        }
        // validar que el campo de usuario no tenga caracteres especiales ni numeros
        else if (!username.matches("[a-zA-Z]*")) {
            showErrorAlert("El campo de usuario no puede contener caracteres especiales ni números");
        }


    }

    @FXML
    private void validarPassword (KeyEvent event) {
        String password = passwordField.getText();
        if (password.isEmpty()) {
            showErrorAlert("El campo de contraseña no puede estar vacío");
        }
    }

    @FXML
    private void mostrarPassword(MouseEvent event) {
        passwordField.setVisible(false);
        plainPasswordField.setText(passwordField.getText());
        plainPasswordField.setVisible(true);
        showPasswordButton.setVisible(false);
        hidePasswordButton.setVisible(true);
    }

    @FXML
    private void ocultarPassword(MouseEvent event) {
        plainPasswordField.setVisible(false);
        passwordField.setText(plainPasswordField.getText());
        passwordField.setVisible(true);
        showPasswordButton.setVisible(true);
        hidePasswordButton.setVisible(false);
    }


    public static void showSuccessAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Éxito");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
