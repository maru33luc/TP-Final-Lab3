package com.example.tpfinallab3.controllers;

import com.example.tpfinallab3.models.Autenticable;
import com.example.tpfinallab3.models.WindowButtons;
import com.example.tpfinallab3.security.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.action.Action;

import java.io.IOException;
import java.security.Key;

public class LoginController {

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
    private Hyperlink olvidoPasswordLink;

    @FXML
    private Hyperlink olvidoUsuarioLink;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label passwordLabel;

    @FXML
    private TextField plainPasswordField;

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

    protected static Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void clickLogin(ActionEvent event) {

        //si el nombre de usuario y contraseña ingresados son correctos
        if (SessionManager.getInstance().iniciarSesion(usernameField.getText().toLowerCase(), passwordField.getText())) {

            //se muestra un mensaje de bienvenida
            Autenticable usuarioAutenticado = SessionManager.getInstance().getEntidadLogueada();
            showSuccessAlert("Bienvenido " + usuarioAutenticado.getNombre() + " " + usuarioAutenticado.getApellido() + "!"); //lo comenté porque ya está el panel de bienvenida en la view

            //según el tipo de usuario que ingresó se carga la vista correspondiente
            FXMLLoader fxmlLoader;
            Parent root;

            if (SessionManager.getInstance().getTipoEntidad().equals("paciente")) {
                fxmlLoader = new FXMLLoader(LoginController.class.getResource("/com/example/tpfinallab3/paciente-view.fxml"));
            }
            else if (SessionManager.getInstance().getTipoEntidad().equals("medico")) {
                fxmlLoader = new FXMLLoader(LoginController.class.getResource("/com/example/tpfinallab3/medico-view.fxml"));
            }
            else {
                fxmlLoader = new FXMLLoader(LoginController.class.getResource("/com/example/tpfinallab3/admin-view.fxml"));
            }

            try {
                root = fxmlLoader.load();
            }
            catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            WindowButtons windowButtons = new WindowButtons(stage, root);
            stage.show();
        }
        //si el nombre de usuario y/o contraseña ingresados son incorrectos se muestra un mensaje de error
        else {
            showErrorAlert("Nombre de usuario y/o contraseña incorrectos");
        }
    }

    @FXML
    private void clickRegistro(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/com/example/tpfinallab3/registro-view.fxml"));
        Parent root;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        WindowButtons windowButtons = new WindowButtons(stage, root); //nuevo
        stage.show();
    }

    @FXML
    private void mostrarPassword(MouseEvent event) {
        passwordField.setVisible(false);
        plainPasswordField.setText(passwordField.getText());
        plainPasswordField.setVisible(true);
        showPasswordButton.setVisible(true);
        hidePasswordButton.setVisible(false);
    }

    @FXML
    private void ocultarPassword(MouseEvent event) {
        plainPasswordField.setVisible(false);
        passwordField.setText(plainPasswordField.getText());
        passwordField.setVisible(true);
        showPasswordButton.setVisible(false);
        hidePasswordButton.setVisible(true);
    }

    @FXML
    void recuperarContrasena(ActionEvent event) {
        showSuccessAlert("Se abrirá el navegador para acceder al sitio que le permitirá reestablecer su contraseña...");
    }

    @FXML
    void recuperarUsuario(ActionEvent event) {
        showSuccessAlert("Se abrirá el navegador para acceder al sitio que le permitirá recuperar su usuario...");
    }

    protected static void mostrarLogin() {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/com/example/tpfinallab3/login-view.fxml"));
        Parent root;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        WindowButtons windowButtons = new WindowButtons(stage, root); //nuevo
        LoginController.stage.show();
    }

    protected static void showSuccessAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.setContentText(message);

        DialogPane dialogPane = alert.getDialogPane();

        dialogPane.getStylesheets().add("styles.css");
        dialogPane.getStyleClass().add("success-alert");

        alert.showAndWait();
    }

    protected static void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.setTitle(null);
        alert.setHeaderText(null);

        DialogPane dialogPane = alert.getDialogPane();

        dialogPane.getStylesheets().add("styles.css");
        dialogPane.getStyleClass().add("error-alert");


        alert.showAndWait();
    }

    @FXML
    private void loginKeyEnter(KeyEvent event){ //iniciar sesion con enter
        ActionEvent evento = new ActionEvent();
        if (event.getCode().getName().equals("Enter")) {
            clickLogin(evento);
        }
    }
}
