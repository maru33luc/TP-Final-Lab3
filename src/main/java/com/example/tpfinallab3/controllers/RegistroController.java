package com.example.tpfinallab3.controllers;

import com.example.tpfinallab3.models.Paciente;
import com.example.tpfinallab3.security.AuthenticationService;
import com.example.tpfinallab3.security.ValidationService;
import com.example.tpfinallab3.services.PacienteService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class RegistroController {

    @FXML
    private TextField apellidoNuevoPacienteField;

    @FXML
    private Label apellidoNuevoPacienteLabel;

    @FXML
    private TextField emailNuevoPacienteField;

    @FXML
    private Label emailNuevoPacienteLabel;

    @FXML
    private Button guardarNuevoPacienteButton;

    @FXML
    private ImageView hidePasswordButton;

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
    private PasswordField passwordNuevoPacienteField;

    @FXML
    private Label passwordNuevoPacienteLabel;

    @FXML
    private TextField plainPasswordNuevoPacienteField;

    @FXML
    private AnchorPane registrarsePanel;

    @FXML
    private ImageView showPasswordButton;

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

        //se crea un paciente con los datos ingresados
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
            //se validan los datos ingresados
            ValidationService.getInstance().validarDatosNuevoUsuario(paciente);
            //se agrega el paciente al listado de pacientos
            PacienteService.getInstance().agregarPaciente(paciente);
            //se muestra un mensaje de éxito y se vuelve al login
            System.out.println(AuthenticationService.getInstance().getUsuarios());
            LoginController.showSuccessAlert("Nuevo usuario creado exitosamente");
            LoginController.mostrarLogin();
        }
        catch (Exception e) {
            LoginController.showErrorAlert(e.getMessage());
        }
    }

    @FXML
    private void mostrarPassword(MouseEvent event) {
        passwordNuevoPacienteField.setVisible(false);
        plainPasswordNuevoPacienteField.setText(passwordNuevoPacienteField.getText());
        plainPasswordNuevoPacienteField.setVisible(true);
        showPasswordButton.setVisible(true);
        hidePasswordButton.setVisible(false);
    }

    @FXML
    private void ocultarPassword(MouseEvent event) {
        plainPasswordNuevoPacienteField.setVisible(false);
        passwordNuevoPacienteField.setText(plainPasswordNuevoPacienteField.getText());
        passwordNuevoPacienteField.setVisible(true);
        showPasswordButton.setVisible(false);
        hidePasswordButton.setVisible(true);
    }
}
