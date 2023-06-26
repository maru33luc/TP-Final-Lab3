package com.example.tpfinallab3.controllers;

import com.example.tpfinallab3.models.*;
import com.example.tpfinallab3.security.AuthenticationService;
import com.example.tpfinallab3.security.SessionManager;
import com.example.tpfinallab3.security.ValidationService;
import com.example.tpfinallab3.services.MedicoService;
import com.example.tpfinallab3.services.PacienteService;
import com.example.tpfinallab3.services.TurnoService;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class PacienteViewController {

    private LoginController loginController;

    @FXML
    private Label addAppointmentButton;

    @FXML
    private Label apellidoPacienteLabel;

    @FXML
    private Label appointmentListButton;

    @FXML
    private AnchorPane bienvenidoUserPanel;

    @FXML
    private Label logoutPacienteButton;

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
    private ChoiceBox<Especialidad> especialidadPacienteChoiceBox;

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
    private ChoiceBox<String> medicoPacienteChoiceBox;

    @FXML
    private Label medicoTurnoPacienteLabel;

    @FXML
    private Label misTurnosPacienteLabel;

    @FXML
    private AnchorPane misTurnosPacientePanel;

    @FXML
    private AnchorPane misTurnosPacienteView;

    @FXML
    private ImageView mostrarNewPasswordEditarPacienteButton;

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
    private ImageView ocultarNewPasswordEditarPacienteButton;

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
    private TextField plainNewPasswordPacienteField;

    @FXML
    private AnchorPane profileDataPacientePanel;

    @FXML
    private AnchorPane profilePacientePanel;

    @FXML
    private Button submitChangesPacienteButton;

    @FXML
    private TableView<TurnoTabla> tablaMisTurnosPaciente;

    @FXML
    private TableView<TurnoTabla> tablaTurnosPaciente;

    @FXML
    private Label telefonoPacienteLabel;

    private ObservableList<Turno> turnosPaciente;

    // Crear dos propiedades booleanas para controlar el estado de selección de los ChoiceBox
    private BooleanProperty especialidadSelected = new SimpleBooleanProperty(false);
    private BooleanProperty medicoSelected = new SimpleBooleanProperty(false);

    @FXML
    public void initialize() {
        Autenticable usuarioLogueado = SessionManager.getInstance().getEntidadLogueada();

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

        // ------------------------ DESCA ACA LO Q HAGO ES PARA CARGAR ALGUN TURNO O MAS DE UNO Y TESTEAR ----------------

        // desde el usuario logueado recuperar la instancia de Paciente
        Optional<Paciente> paciente = PacienteService.getInstance().buscarPacientePorNombreUsuario(usuarioLogueado.getNombreUsuario());

        Medico medico = new Medico("fgildemuro", "123456", "Federico", "Gil de Muro", "fgildemuro@hotmail.com", Especialidad.CARDIOLOGIA);
        LocalDate dia = LocalDate.of(2023, 6, 16);
        LocalTime horaInicio = LocalTime.of(10, 0);
        LocalTime horaFin = LocalTime.of(16, 0);
        Turno turno = TurnoService.getInstance().buscarTurnosPorDiaPorMedico(dia, medico).get(0);
        TurnoService.getInstance().solicitarTurno(turno, paciente.get());

        // ---------------------- ACA TERMINARIA LO HARCODEADO PARA TESTEAR -------------------------------

        cargarTablaMisTurnos();
        cargarTablaTurnos();

        // cargar los nombres y apellidos de los medicos dentro del choice box
        Set<Medico> medicos = MedicoService.getInstance().getMedicosActivos();

        for (Medico medico2 : medicos) {
            StringBuilder sb = new StringBuilder();
            sb.append(medico2.getNombre());
            sb.append(" ");
            sb.append(medico2.getApellido());

            medicoPacienteChoiceBox.getItems().add(sb.toString());
        }
        // obtener todos los enums de Especialidad dentro de un array pasandolos a String
        especialidadPacienteChoiceBox.getItems().addAll(Especialidad.values());


        /*especialidadPacienteChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                filtrarTurnosPorEspecialidad();
            }
        });

        // detecta el cambio de medico y filtra los turnos por medico
        medicoPacienteChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                filtrarTurnosPorMedico();
            }
        });*/



// En el método initialize() o donde configures tus componentes, añade los listeners
        especialidadPacienteChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                filtrarTurnosPorEspecialidad();
            }
        });

        medicoPacienteChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                filtrarTurnosPorMedico();
            }
        });

// Agrega un listener al ChoiceBox de especialidades para deseleccionar el ChoiceBox de médicos
        especialidadPacienteChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                medicoPacienteChoiceBox.getSelectionModel().clearSelection();
            }
        });

// Agrega un listener al ChoiceBox de médicos para deseleccionar el ChoiceBox de especialidades
        medicoPacienteChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                especialidadPacienteChoiceBox.getSelectionModel().clearSelection();
            }
        });


    }

    void cargarTablaMisTurnos() {
        Autenticable paciente = SessionManager.getInstance().getEntidadLogueada();
        List<Turno> listaMisTurnos = TurnoService.getInstance().buscarTurnosPorPaciente((Paciente) paciente);

        List<TurnoTabla> listaMisTurnos2 = new ArrayList<>();

        // Iterar sobre los turnos y crear instancias de TurnoTabla
        for (Turno turno5 : listaMisTurnos) {
            Especialidad especialidad = turno5.getMedico().getEspecialidad();
            Medico medico2 = turno5.getMedico();
            TurnoTabla turnoTabla = new TurnoTabla(turno5.getDia(), turno5.getHora(), especialidad, medico2,(Paciente) paciente, ((Paciente) paciente).getObraSocial());
            listaMisTurnos2.add(turnoTabla);
        }
        columnaFechaMiTurnoPaciente.setCellValueFactory(new PropertyValueFactory<>("dia"));
        columnaHoraMiTurnoPaciente.setCellValueFactory(new PropertyValueFactory<>("hora"));
        columnaEspMiTurnoPaciente.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
        columnaMedicoMiTurnoPaciente.setCellValueFactory(new PropertyValueFactory<>("medico"));

        tablaMisTurnosPaciente.setItems(FXCollections.observableArrayList(listaMisTurnos2));
    }

    void cargarTablaTurnos() {
        Autenticable paciente = SessionManager.getInstance().getEntidadLogueada();
        List<Turno> listaTurnos = TurnoService.getInstance().buscarTurnosDisponibles();
        List<TurnoTabla> listaTurnos3 = new ArrayList<>();

        // Iterar sobre los turnos y crear instancias de TurnoTabla
        for (Turno turno : listaTurnos) {
            Especialidad especialidad = turno.getMedico().getEspecialidad();
            Medico medico2 = turno.getMedico();
            TurnoTabla turnoTabla = new TurnoTabla(turno.getDia(), turno.getHora(), especialidad, medico2,null,null);
            listaTurnos3.add(turnoTabla);
        }
        columnaFechaTurnoPaciente.setCellValueFactory(new PropertyValueFactory<>("dia"));
        columnaHoraTurnoPaciente.setCellValueFactory(new PropertyValueFactory<>("hora"));
        columnaEspecialidadTurnoPaciente.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
        columnaMedicoTurnoPaciente.setCellValueFactory(new PropertyValueFactory<>("medico"));

        tablaTurnosPaciente.setItems(FXCollections.observableArrayList(listaTurnos3));
    }

    @FXML
    void filtrarEspecialidadAction(MouseEvent event) {

    }
    void filtrarTurnosPorEspecialidad() {

        List<Turno> listaTurnos = TurnoService.getInstance().buscarTurnosDisponibles();
        ObservableList<TurnoTabla> listaTurnos2 = FXCollections.observableArrayList();
        for (Turno turno : listaTurnos) {

            if (especialidadPacienteChoiceBox.getSelectionModel().getSelectedItem().equals(turno.getMedico().getEspecialidad())) {
                Especialidad especialidad = turno.getMedico().getEspecialidad();
                Medico medico2 = turno.getMedico();
                TurnoTabla turnoTabla = new TurnoTabla(turno.getDia(), turno.getHora(), especialidad, medico2,null,null);
                listaTurnos2.add(turnoTabla);
            }
        }
        columnaFechaTurnoPaciente.setCellValueFactory(new PropertyValueFactory<>("dia"));
        columnaHoraTurnoPaciente.setCellValueFactory(new PropertyValueFactory<>("hora"));
        columnaEspecialidadTurnoPaciente.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
        columnaMedicoTurnoPaciente.setCellValueFactory(new PropertyValueFactory<>("medico"));

        tablaTurnosPaciente.setItems(FXCollections.observableArrayList(listaTurnos2));
    }
    
    void filtrarTurnosPorMedico() {

        List<Turno> listaTurnos = TurnoService.getInstance().buscarTurnosDisponibles();
        ObservableList<TurnoTabla> listaTurnos2 = FXCollections.observableArrayList();

        for (Turno turno : listaTurnos) {

            if (medicoPacienteChoiceBox.getSelectionModel().getSelectedItem().equals(turno.getMedico().getNombre() + " " + turno.getMedico().getApellido())) {

                Especialidad especialidad = turno.getMedico().getEspecialidad();
                Medico medico2 = turno.getMedico();
                TurnoTabla turnoTabla = new TurnoTabla(turno.getDia(), turno.getHora(), especialidad, medico2,null,null);
                listaTurnos2.add(turnoTabla);
            }
        }
        columnaFechaTurnoPaciente.setCellValueFactory(new PropertyValueFactory<>("dia"));
        columnaHoraTurnoPaciente.setCellValueFactory(new PropertyValueFactory<>("hora"));
        columnaEspecialidadTurnoPaciente.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
        columnaMedicoTurnoPaciente.setCellValueFactory(new PropertyValueFactory<>("medico"));

        tablaTurnosPaciente.setItems(FXCollections.observableArrayList(listaTurnos2));
    }

    @FXML
    void miPerfilAction(MouseEvent event) {
        bienvenidoUserPanel.setVisible(false);
        profilePacientePanel.setVisible(true);
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
            cargarTablaTurnos();
    }

    @FXML
    void verTurnosAction(MouseEvent event) {
            bienvenidoUserPanel.setVisible(false);
            profileDataPacientePanel.setVisible(false);
            misTurnosPacienteView.setVisible(true);
            pedirTurnoPacienteView.setVisible(false);
            editProfilePacientePanel.setVisible(false);
            cargarTablaMisTurnos();
    }

    @FXML
    void editarDatosPacienteEvent(ActionEvent event) {
        profileDataPacientePanel.setVisible(false);
        editProfilePacientePanel.setVisible(true);
        misTurnosPacienteView.setVisible(false);
        pedirTurnoPacienteView.setVisible(false);
    }

    @FXML
    void seleccionarMisTurnosAction(MouseEvent event) {
        TurnoTabla turnoTabla = tablaMisTurnosPaciente.getSelectionModel().getSelectedItem();
        if (turnoTabla != null) {
            especialidadMiTurnoPacienteLabel.setText(turnoTabla.getEspecialidad().toString());
            medicoMiTurnoPacienteLabel.setText(turnoTabla.getMedico());
            fechaMiTurnoPacienteLabel.setText(turnoTabla.getDia().toString());
            horaMiTurnoPacienteLabel.setText(turnoTabla.getHora().toString());
        }
    }

    @FXML
    void seleccionarUnTurnoAction(MouseEvent event) {
        TurnoTabla turnoTabla = tablaTurnosPaciente.getSelectionModel().getSelectedItem();
        if (turnoTabla != null) {
            especialidadTurnoPacienteLabel.setText(turnoTabla.getEspecialidad().toString());
            medicoTurnoPacienteLabel.setText(turnoTabla.getMedico());
            fechaTurnoPacienteLabel.setText(turnoTabla.getDia().toString());
            horaTurnoPacienteLabel.setText(turnoTabla.getHora().toString());
        }
    }

    @FXML
    void solicitarTurnoAction(ActionEvent event) {
        if(especialidadTurnoPacienteLabel.getText().equals("")) {
            LoginController.showErrorAlert("No se ha seleccionado ningun turno");
        }else{
            Optional<Paciente> pacienteOptional = PacienteService.getInstance().buscarPacientePorNombreUsuario(SessionManager.getInstance().getEntidadLogueada().getNombreUsuario());
            Paciente paciente = pacienteOptional.get();

            Medico medico = MedicoService.getInstance().retornaMedicoPorCampoTextField(medicoTurnoPacienteLabel.getText());
            LocalDate dia = LocalDate.parse(fechaTurnoPacienteLabel.getText());
            LocalTime hora = LocalTime.parse(horaTurnoPacienteLabel.getText());
            Turno turno = TurnoService.getInstance().buscarTurnoPorMedicoDiaYHora(medico, dia, hora);

            if(turno!=null){
                if(TurnoService.getInstance().buscarTurnosPorPaciente(paciente).contains(turno)){
                    LoginController.showErrorAlert("Ya tiene un turno con ese medico en esa fecha y hora");
                }else{
                    TurnoService.getInstance().solicitarTurno(turno, paciente);
                    LoginController.showSuccessAlert("Turno solicitado con exito");
                    cargarTablaTurnos();
                }
            }
        }
    }

    @FXML
    void cancelarTurnoAction(MouseEvent event) {

        if(especialidadMiTurnoPacienteLabel.getText().equals("")) {
            LoginController.showErrorAlert("No se ha seleccionado ningun turno");
        }else{

            Optional<Paciente> pacienteOptional = PacienteService.getInstance().buscarPacientePorNombreUsuario(SessionManager.getInstance().getEntidadLogueada().getNombreUsuario());
            Paciente paciente = pacienteOptional.get();

            String input = medicoMiTurnoPacienteLabel.getText();
            String[] palabras = input.split(" ");

            String nombreMedico = palabras[0];
            StringBuilder apellidoMedicoBuilder = new StringBuilder();

            // Combinar las palabras del apellido en una sola cadena
            for (int i = 1; i < palabras.length; i++) {
                if (i > 1) {
                    apellidoMedicoBuilder.append(" ");  // Agregar espacio entre las palabras
                }
                apellidoMedicoBuilder.append(palabras[i]);
            }
            String apellidoMedico = apellidoMedicoBuilder.toString();
            Medico medico = MedicoService.getInstance().buscarMedicoPorNombreYApellido(nombreMedico, apellidoMedico);
            LocalDate dia = LocalDate.parse(fechaMiTurnoPacienteLabel.getText());
            LocalTime hora = LocalTime.parse(horaMiTurnoPacienteLabel.getText());
            Turno turno = TurnoService.getInstance().buscarTurnoPorPacienteMedicoYFecha(paciente, medico, dia, hora);
            if(turno!=null){
                TurnoService.getInstance().marcarTurnoComoDisponible(turno) ;
                LoginController.showSuccessAlert("Turno cancelado con exito");
                cargarTablaMisTurnos();
            }
        }
    }

    @FXML
    void logoutPaciente(MouseEvent event) {
        SessionManager.getInstance().cerrarSesion();
        //volver a la vista principal
        LoginController.mostrarLogin();
    }

    public void setMainController(LoginController loginController) {
          this.loginController = loginController;
    }

//EDITAR PERFIL PACIENTE///////////////////////////////////////////////////////////////////////////////////////

    @FXML
    private void guardarDatosPacienteEvent(ActionEvent event) {

        //se guardan los datos ingresados en variables
        String nombre = editNombrePacienteField.getText();
        String apellido = editApellidoPacienteField.getText();
        String mail = editEmailPacienteField.getText();
        String telefono = editTelefonoPacienteField.getText();
        String obraSocial = editObraSocPacienteField.getText();
        String numeroAfiliado = editNroAfiliadoPacienteField.getText();
        String contrasena = newPasswordPacienteField.getText();

        try {

            //se validan los datos ingresados
            ValidationService.getInstance().validarDatosEditarPerfilPaciente(nombre, apellido, mail, telefono, obraSocial, numeroAfiliado, contrasena);

            //se recupera el usuario logueado
            String usuario = SessionManager.getInstance().getEntidadLogueada().getNombreUsuario();

            //se modifica la contraseña del usuario logueado
            AuthenticationService.getInstance().modificarContraseña(usuario, contrasena);

            //se modifica los restantes datos del usuario logueado en la lista de pacientes y el json
            PacienteService.getInstance().modificarPaciente(usuario, nombre, apellido, mail, telefono, obraSocial, numeroAfiliado);

            //se setean los datos a mostrar en el perfil para esta sesión
            nombrePacienteLabel.setText(nombre);
            apellidoPacienteLabel.setText(apellido);
            emailPacienteLabel.setText(mail);
            telefonoPacienteLabel.setText(telefono);
            obraSocialPacienteLabel.setText(obraSocial);
            nroAfiliadoPacienteLabel.setText(numeroAfiliado);

            //se envía mensaje de éxito en la modificación
            LoginController.showSuccessAlert("Datos modificados exitosamente");

            //se muestra el perfil del paciente
            mostrarPerfil();
        } catch (Exception e) {
            //se envía mensaje de error si se lanzó alguna excepción en las validaciones
            LoginController.showErrorAlert(e.getMessage());
        }
    }

    @FXML
    private void mostrarPassword(MouseEvent event) {
        newPasswordPacienteField.setVisible(false);
        plainNewPasswordPacienteField.setText(newPasswordPacienteField.getText());
        plainNewPasswordPacienteField.setVisible(true);
        mostrarNewPasswordEditarPacienteButton.setVisible(true);
        ocultarNewPasswordEditarPacienteButton.setVisible(false);
    }

    @FXML
    private void ocultarPassword(MouseEvent event) {
        plainNewPasswordPacienteField.setVisible(false);
        newPasswordPacienteField.setText(plainNewPasswordPacienteField.getText());
        newPasswordPacienteField.setVisible(true);
        mostrarNewPasswordEditarPacienteButton.setVisible(false);
        ocultarNewPasswordEditarPacienteButton.setVisible(true);
    }

    private void mostrarPerfil(){
        bienvenidoUserPanel.setVisible(false);
        profilePacientePanel.setVisible(true);
        profileDataPacientePanel.setVisible(true);
        pedirTurnoPacienteView.setVisible(false);
        misTurnosPacienteView.setVisible(false);
        editProfilePacientePanel.setVisible(false);
    }
}
