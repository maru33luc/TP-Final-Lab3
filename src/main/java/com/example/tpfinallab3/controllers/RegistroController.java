package com.example.tpfinallab3.controllers;

import com.example.tpfinallab3.models.Paciente;
import com.example.tpfinallab3.security.AuthenticationService;
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
    private TextField fechaNacNuevoPacienteField;

    @FXML
    private Label fechaNacNuevoPacienteLabel;

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
    private CheckBox terminosNuevoPacienteCheckBox;

    @FXML
    private Label terminosNuevoPacienteLabel;

    @FXML
    private ChoiceBox<?> tipoDocNuevoPacienteChoiceBox;

    @FXML
    private Label tipoDocNuevoPacienteLabel;

    @FXML
    private TextField userNuevoPacienteField;

    @FXML
    private Label userNuevoPacienteLabel;

    private void clickGuardar(ActionEvent event) {
        String nombreUsuario = userNuevoPacienteField.getText();
        String contrasena = passwordNuevoPacienteField.getText();
        String nombre = nombreNuevoPacienteField.getText();
        String apellido = apellidoNuevoPacienteField.getText();
        String mail = emailNuevoPacienteField.getText();
        String dni = nroDocNuevoPacienteField.getText();
        String telefono = telefonoNuevoPacienteField.getText();
        String obraSocial = obraSocialNuevoPacienteField.getText();
        String numeroAfiliado = nroAfiliadoNuevoPacienteField.getText();

        StringBuilder mensajeError = new StringBuilder();
        if(AuthenticationService.getInstance().usuarioExiste(nombreUsuario)) {
            mensajeError.append("Ya existe un usuario registrado con el mismo nombre\n");
        }
        if (contrasena.length() < 6) {
            mensajeError.append("La contraseña es demasiado corta (mínimo 6 caracteres)\n");
        }
        if (nombreUsuario.isEmpty() || contrasena.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || mail.isEmpty() || dni.isEmpty()) {
            mensajeError.append("Debe completar todos los campos marcados con *\n");
        }

        if(mensajeError.isEmpty()) {//si se validó correctamente
            Paciente paciente = new Paciente(nombreUsuario, contrasena, nombre, apellido, mail, dni, telefono, obraSocial, numeroAfiliado);
            PacienteService.getInstance().agregarPaciente(paciente);
            showSuccessAlert("Usuario creado");
            //todo ir a login
        }
        else {
            showErrorAlert(mensajeError.toString());
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
}

