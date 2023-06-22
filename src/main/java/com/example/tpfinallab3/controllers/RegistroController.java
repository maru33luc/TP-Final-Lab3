package com.example.tpfinallab3.controllers;

import com.example.tpfinallab3.models.Paciente;
import com.example.tpfinallab3.security.AuthenticationService;
import com.example.tpfinallab3.security.ValidationService;
import com.example.tpfinallab3.services.PacienteService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class RegistroController {

    @FXML
    private TextField apellidoNuevoPacienteField;

    @FXML
    private Label apellidoNuevoPacienteLabel;

    @FXML
    private AnchorPane closeNuevoPacienteButton;

    @FXML
    private Label docturnoBarraNuevoPacienteLabel;

    @FXML
    private TextField emailNuevoPacienteField;

    @FXML
    private Label emailNuevoPacienteLabel;

    @FXML
    private Button guardarNuevoPacienteButton;

    @FXML
    private AnchorPane minimizeNuevoPacienteButton;

    @FXML
    private TextField nombreNuevoPacienteField;

    @FXML
    private Label nombreNuevoPacienteLabel;

    @FXML
    private TextField nroAfiliadoNuevoPacienteField;

    @FXML
    private Label nroAfiliadoNuevoPacienteLabel;

    @FXML
    private TextField nroDocNuevoPacienteField;

    @FXML
    private Label nroDocNuevoPacienteLabel;

    @FXML
    private Label nuevoPacienteLabel;

    @FXML
    private TextField obraSocialNuevoPacienteField;

    @FXML
    private Label obraSocialNuevoPacienteLabel;

    @FXML
    private ImageView ojoCloseNuevoPacienteButton;

    @FXML
    private ImageView ojoOpenNuevoPacienteButton;

    @FXML
    private PasswordField passwordNuevoPacienteField;

    @FXML
    private Label passwordNuevoPacienteLabel;

    @FXML
    private AnchorPane registrarsePanel;

    @FXML
    private TextField telefonoNuevoPacienteField;

    @FXML
    private Label telefonoNuevoPacienteLabel;

    @FXML
    private TextField userNuevoPacienteField;

    @FXML
    private Label userNuevoPacienteLabel;

    @FXML
    private Button volverButton;

    @FXML
    private void clickVolver(ActionEvent event) {
        LoginController.mostrarLogin();
    }

    @FXML
    void clickGuardar(ActionEvent event) {
        Paciente paciente = new Paciente(userNuevoPacienteField.getText().toLowerCase(),
                passwordNuevoPacienteField.getText(),
                nombreNuevoPacienteField.getText(),
                apellidoNuevoPacienteField.getText(),
                emailNuevoPacienteField.getText(),
                nroDocNuevoPacienteField.getText(),
                telefonoNuevoPacienteField.getText(),
                obraSocialNuevoPacienteField.getText(),
                nroAfiliadoNuevoPacienteField.getText());
        try {
            ValidationService.getInstance().validarDatosNuevoUsuario(paciente);
            PacienteService.getInstance().agregarPaciente(paciente);
            LoginController.showSuccessAlert("Nuevo usuario creado exitosamente");
            LoginController.mostrarLogin();
        }
        catch (Exception e) {
            LoginController.showErrorAlert(e.getMessage());
        }
    }
}
