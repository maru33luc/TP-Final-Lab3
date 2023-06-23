package com.example.tpfinallab3.controllers;

import com.example.tpfinallab3.models.*;
import com.example.tpfinallab3.security.SessionManager;
import com.example.tpfinallab3.services.PacienteService;
import com.example.tpfinallab3.services.TurnoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private TableView<TurnoTabla> tablaMisTurnosPaciente;

    @FXML
    private TableView<?> tablaTurnosPaciente;

    @FXML
    private Label telefonoPacienteLabel;

    private ObservableList<Turno> turnosPaciente;

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

       // turnosPaciente = FXCollections.observableArrayList();

        // ------------------------ DESCA ACA LO Q HAGO ES PARA CARGAR ALGUN TURNO O MAS DE UNO Y TESTEAR ----------------

        // desde el usuario logueado recuperar la instancia de Paciente
        Optional<Paciente> paciente = PacienteService.getInstance().buscarPacientePorNombreUsuario(usuarioLogueado.getNombreUsuario());

        Medico medico = new Medico("fgildemuro", "123456", "Federico", "Gil de Muro", "fgildemuro@hotmail.com", Especialidad.CARDIOLOGIA);
        LocalDate dia = LocalDate.of(2023, 6, 16);
        Turno turno = TurnoService.getInstance().buscarTurnosPorDiaPorMedico(dia, medico).get(0);
        TurnoService.getInstance().solicitarTurno(turno,paciente.get());

        // ---------------------- ACA TERMINARIA LO HARCODEADO PARA TESTEAR -------------------------------

        cargarTablaMisTurnos();

    }

    void cargarTablaMisTurnos(){
        Autenticable paciente= SessionManager.getInstance().getEntidadLogueada();
        List<Turno> listaMisTurnos= TurnoService.getInstance().buscarTurnosPorPaciente((Paciente) paciente);

        List<TurnoTabla> listaMisTurnos2 = new ArrayList<>();

        // Iterar sobre los turnos y crear instancias de TurnoTabla
        for (Turno turno5 : listaMisTurnos) {
            Especialidad especialidad = turno5.getMedico().getEspecialidad();
            Medico medico2 = turno5.getMedico();
            TurnoTabla turnoTabla = new TurnoTabla(turno5.getDia(), turno5.getHora(), especialidad, medico2);
            listaMisTurnos2.add(turnoTabla);
        }

        columnaFechaMiTurnoPaciente.setCellValueFactory(new PropertyValueFactory<>("dia"));
        columnaHoraMiTurnoPaciente.setCellValueFactory(new PropertyValueFactory<>("hora"));
        columnaEspMiTurnoPaciente.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
        columnaMedicoMiTurnoPaciente.setCellValueFactory(new PropertyValueFactory<>("medico"));

        tablaMisTurnosPaciente.setItems(FXCollections.observableArrayList(listaMisTurnos2));
    }

    @FXML
    void miPerfilAction(MouseEvent event) {
            profileDataPacientePanel.setVisible(true);
            pedirTurnoPacienteView.setVisible(false);
            misTurnosPacienteView.setVisible(false);
            editProfilePacientePanel.setVisible(false);
    }

    @FXML
    void pedirTurnosAction(MouseEvent event) {
            profileDataPacientePanel.setVisible(false);
            pedirTurnoPacienteView.setVisible(true);
            misTurnosPacienteView.setVisible(false);
            editProfilePacientePanel.setVisible(false);

    }

    @FXML
    void verTurnosAction(MouseEvent event) {
            profileDataPacientePanel.setVisible(false);
            misTurnosPacienteView.setVisible(true);
            pedirTurnoPacienteView.setVisible(false);
            editProfilePacientePanel.setVisible(false);

    }

    @FXML
    void editarDatosPacienteEvent(ActionEvent event) {
        profileDataPacientePanel.setVisible(false);
        editProfilePacientePanel.setVisible(true);
        misTurnosPacienteView.setVisible(false);
        pedirTurnoPacienteView.setVisible(false);

    }

    @FXML
    void guardarDatosPacienteEvent(ActionEvent event) {


    }

    @FXML
    void seleccionarMisTurnosAction(MouseEvent event) {
        TurnoTabla turnoTabla = tablaMisTurnosPaciente.getSelectionModel().getSelectedItem();
        System.out.println("turnoTabla.toString() = " + turnoTabla.toString());
        if (turnoTabla != null) {
            especialidadMiTurnoPacienteLabel.setText(turnoTabla.getEspecialidad().toString());
            medicoMiTurnoPacienteLabel.setText(turnoTabla.getMedico());
            fechaMiTurnoPacienteLabel.setText(turnoTabla.getDia().toString());
            horaMiTurnoPacienteLabel.setText(turnoTabla.getHora().toString());

        }
    }

    public void setMainController(LoginController loginController) {
          this.loginController = loginController;
    }
}
