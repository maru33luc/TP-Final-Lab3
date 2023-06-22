package com.example.tpfinallab3.controllers;

import com.example.tpfinallab3.models.Autenticable;
import com.example.tpfinallab3.models.Paciente;
import com.example.tpfinallab3.security.SessionManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class PacienteViewController {

    private LoginController loginController;

    @FXML
    private Label addAppointmentButton;

    @FXML
    private Label apellidoPacienteLabel;

    @FXML
    private Label appointmentListButton;

    @FXML
    private Button cancelarTurnoPacienteButton;

    @FXML
    private TableColumn<?, ?> columnaEspMiTurnoPaciente;

    @FXML
    private TableColumn<?, ?> columnaEspecialidadTurnoPaciente;

    @FXML
    private TableColumn<?, ?> columnaFechaMiTurnoPaciente;

    @FXML
    private TableColumn<?, ?> columnaFechaTurnoPaciente;

    @FXML
    private TableColumn<?, ?> columnaHoraMiTurnoPaciente;

    @FXML
    private TableColumn<?, ?> columnaHoraTurnoPaciente;

    @FXML
    private TableColumn<?, ?> columnaMedicoMiTurnoPaciente;

    @FXML
    private TableColumn<?, ?> columnaMedicoTurnoPaciente;

    @FXML
    private PasswordField confirmPasswordPacienteField;

    @FXML
    private Label confirmPasswordPacienteLabel;

    @FXML
    private TextField editApellidoPacienteField;

    @FXML
    private TextField editEmailPacienteField;

    @FXML
    private TextField editNombrePacienteField;

    @FXML
    private TextField editNroAfiliadoPacienteField;

    @FXML
    private TextField editObraSocPacienteField;

    @FXML
    private Button editPacienteButton;

    @FXML
    private AnchorPane editProfilePacientePanel;

    @FXML
    private TextField editTelefonoPacienteField;

    @FXML
    private Label emailPacienteLabel;

    @FXML
    private Label especialidadMiTurnoPacienteLabel;

    @FXML
    private ChoiceBox<?> especialidadPacienteChoiceBox;

    @FXML
    private Label especialidadTurnoPacienteLabel;

    @FXML
    private Label fechaMiTurnoPacienteLabel;

    @FXML
    private Label fechaNacPacienteLabel;

    @FXML
    private Label fechaNacimientoPaciente;

    @FXML
    private Label fechaTurnoPacienteLabel;

    @FXML
    private Label horaMiTurnoPacienteLabel;

    @FXML
    private Label horaTurnoPacienteLabel;

    @FXML
    private Label medicoMiTurnoPacienteLabel;

    @FXML
    private ChoiceBox<?> medicoPacienteChoiceBox;

    @FXML
    private Label medicoTurnoPacienteLabel;

    @FXML
    private Label misTurnosPacienteLabel;

    @FXML
    private AnchorPane misTurnosPacientePanel;

    @FXML
    private AnchorPane misTurnosPacienteView;

    @FXML
    private Label myProfileButton;

    @FXML
    private PasswordField newPasswordPacienteField;

    @FXML
    private Label newPasswordPacienteLabel;

    @FXML
    private Label nombrePacienteLabel;

    @FXML
    private Label nroAfiliadoPacienteLabel;

    @FXML
    private Label nroDocumentoPaciente;

    @FXML
    private Label nroDocumentoPacienteLabel;

    @FXML
    private Label obraSocialPacienteLabel;

    @FXML
    private PasswordField oldPasswordPacienteField;

    @FXML
    private Label oldPasswordPacienteLabel;

    @FXML
    private Label pacienteUserName;

    @FXML
    private Button pedirTurnoPacienteButton;

    @FXML
    private Label pedirTurnoPacienteLabel;

    @FXML
    private AnchorPane pedirTurnoPacientePanel;

    @FXML
    private AnchorPane pedirTurnoPacienteView;

    @FXML
    private AnchorPane profileDataPacientePanel;

    @FXML
    private AnchorPane profilePacientePanel;

    @FXML
    private Button submitChangesPacienteButton;

    @FXML
    private TableView<?> tablaMisTurnosPaciente;

    @FXML
    private TableView<?> tablaTurnosPaciente;

    @FXML
    private Label telefonoPacienteLabel;

    @FXML
    public void initialize() {
        Autenticable usuarioLogueado= SessionManager.getInstance().getEntidadLogueada();

        try {
            nombrePacienteLabel.setText(usuarioLogueado.getNombre());
            apellidoPacienteLabel.setText(usuarioLogueado.getApellido());
            telefonoPacienteLabel.setText(((Paciente) usuarioLogueado).getTelefono());
            obraSocialPacienteLabel.setText(((Paciente) usuarioLogueado).getObraSocial());
            nroAfiliadoPacienteLabel.setText(((Paciente) usuarioLogueado).getNumeroAfiliado());
            emailPacienteLabel.setText(usuarioLogueado.getMail());
            nroDocumentoPacienteLabel.setText(((Paciente) usuarioLogueado).getDni());
        } catch (ClassCastException e) {
            System.out.println("El usuario logueado no es un paciente");
            e.printStackTrace();
        }
    }

    public void setMainController(LoginController loginController) {
          this.loginController = loginController;
    }
}
