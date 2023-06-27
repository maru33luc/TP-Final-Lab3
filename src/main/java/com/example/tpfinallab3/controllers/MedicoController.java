package com.example.tpfinallab3.controllers;

import com.example.tpfinallab3.models.*;
import com.example.tpfinallab3.security.SessionManager;
import com.example.tpfinallab3.services.MedicoService;
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
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MedicoController {

    private LoginController loginController;
    private Stage stage;
    @FXML
    private Label apellidoMedicoLabel;

    @FXML
    private Label appointmentsMedicoButton;

    @FXML
    private Label emailMedicoLabel;

    @FXML
    private Label especialidadMedicoLabel;

    @FXML
    private CheckBox filtrarFechaTurnoMedicoCheck;

    @FXML
    private CheckBox filtrarPacienteTurnoMedicoCheck;


    @FXML
    private AnchorPane myProfileDataMedicoPanel;

    @FXML
    private Label myProfileMedicoButton;

    @FXML
    private Label nombreMedicoLabel;

    @FXML
    private TableColumn tablaMedicoColumnaHora;

    @FXML
    private TableColumn tablaMedicoColumnaPaciente;

    @FXML
    private TableColumn tablaTurnoMedicoColumnaFecha;

    @FXML
    private TableView<TurnoTablaMedico> tablaTurnosMedico;

    @FXML
    private AnchorPane turnosViewMedicoPanel;

    @FXML
    private AnchorPane bienvenidoDoctorPanel; //NUEVO

    @FXML
    private Label ingresarFiltrarTurnosMedicoLabel;

    @FXML
    private TextField filtrarTurnosMedicoField;

    @FXML
    private Button filtrarTurnosMedicoButton;

    @FXML
    private Label doctorUserName;

    //NUEVO MOSTRAR PACIENTE VER TURNO!!
    @FXML
    private AnchorPane pacienteVerTurnosDoctorPanel; //NUEVO

    @FXML
    private AnchorPane buscarTurnosDoctorPanel; //NUEVO

    @FXML
    private Label userPacienteVerTurnoLabel; //NUEVO

    @FXML
    private Label nombrePacienteVerTurnoLabel; //NUEVO

    @FXML
    private Label apellidoPacienteVerTurnoLabel; //NUEVO

    @FXML
    private Label obraSocialPacienteVerTurnoLabel; //NUEVO

    @FXML
    private Label nroAfiliadoPacienteVerTurnoLabel; //NUEVO

    @FXML
    private Button cerrarPacienteVerTurnosButton; //NUEVO

    @FXML
    private Label userMedicoLabel; //NUEVO

    ///////////////////////////////////////////

    @FXML
    private Label logoutMedicoButton;
    @FXML
    private Button limpiarFiltrosButton;

    private ObservableList<Turno> turnosMedico;


    @FXML
    public void initialize(){
        Autenticable usuarioLogueado= SessionManager.getInstance().getEntidadLogueada();
        try{
            doctorUserName.setText(usuarioLogueado.getNombre());
            nombreMedicoLabel.setText(usuarioLogueado.getNombre());
            apellidoMedicoLabel.setText(usuarioLogueado.getApellido());
            userMedicoLabel.setText(usuarioLogueado.getNombreUsuario());
            emailMedicoLabel.setText(usuarioLogueado.getMail());
            especialidadMedicoLabel.setText(((Medico) usuarioLogueado).getEspecialidad().toString());
        }catch (ClassCastException e){
            System.out.println("El usuario logueado no es un medico");
            e.printStackTrace();
        }
        //cargarTablaMedico();
    }

    void cargarTablaMedico(){
        Autenticable usuarioLogueado = SessionManager.getInstance().getEntidadLogueada();
        turnosMedico = FXCollections.observableArrayList();
        Optional<Medico> medico = MedicoService.getInstance().buscarMedicoPorNombreUsuario(usuarioLogueado.getNombreUsuario());
        List<Turno> listaTurnos = TurnoService.getInstance().buscarTurnosPorMedico(medico.get());

        List<TurnoTablaMedico> listaTurnosTabla = new ArrayList<>();
        for(Turno turno : listaTurnos){
            if(turno.getPaciente() != null) {
                TurnoTablaMedico turnoTablaMedico = new TurnoTablaMedico(turno.getDia(), turno.getHora(), turno.getPaciente());
                listaTurnosTabla.add(turnoTablaMedico);
                tablaTurnoMedicoColumnaFecha.setCellValueFactory(new PropertyValueFactory("dia"));
                tablaMedicoColumnaHora.setCellValueFactory(new PropertyValueFactory("hora"));
                tablaMedicoColumnaPaciente.setCellValueFactory(new PropertyValueFactory("paciente"));
            }else{
                TurnoTablaMedico turnoTablaMedico = new TurnoTablaMedico(turno.getDia(), turno.getHora(), null);
                listaTurnosTabla.add(turnoTablaMedico);
                tablaTurnoMedicoColumnaFecha.setCellValueFactory(new PropertyValueFactory("dia"));
                tablaMedicoColumnaHora.setCellValueFactory(new PropertyValueFactory("hora"));
                tablaMedicoColumnaPaciente.setCellValueFactory(new PropertyValueFactory("paciente"));
            }
        }
        tablaTurnosMedico.setItems(FXCollections.observableArrayList(listaTurnosTabla));

    }
    @FXML
    private void verPerfilMedico(MouseEvent event) {
        bienvenidoDoctorPanel.setVisible(false);
        turnosViewMedicoPanel.setVisible(false);

        myProfileDataMedicoPanel.setVisible(true);
    }

    @FXML
    private void verTurnosMedico(MouseEvent event) {
        bienvenidoDoctorPanel.setVisible(false);
        myProfileDataMedicoPanel.setVisible(false);

        cargarTablaMedico();
        turnosViewMedicoPanel.setVisible(true);
    }

    @FXML
    private void buscarTurnosPorFechaMedico (ActionEvent event) { //CORREGIR ESTO
        if (filtrarFechaTurnoMedicoCheck.isSelected()){
            filtrarPacienteTurnoMedicoCheck.setSelected(false);
        }

        ingresarFiltrarTurnosMedicoLabel.setText("Ingrese fecha");
        filtrarTurnosMedicoField.setPromptText("d/m/aaaa");
    }

    @FXML
    private void buscarTurnosPorPacienteMedico (ActionEvent event){ //CORREGIR ESTO
        if (filtrarPacienteTurnoMedicoCheck.isSelected()){
            filtrarFechaTurnoMedicoCheck.setSelected(false);
        }

        ingresarFiltrarTurnosMedicoLabel.setText("Ingrese nombre de paciente");
        filtrarTurnosMedicoField.setPromptText("Nombre y Apellido");
    }

    @FXML
    void clickFiltrarTurnosMedico (ActionEvent event){
        if (filtrarFechaTurnoMedicoCheck.isSelected()){
            turnosPorFecha();
        } else if (filtrarPacienteTurnoMedicoCheck.isSelected()){
            turnosPorPaciente();
        } else {
            LoginController.showErrorAlert("Seleccione una opcion");
        }
    }


    @FXML
    void turnosPorFecha() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        try{
            LocalDate fecha = LocalDate.parse(filtrarTurnosMedicoField.getText(), dateFormatter);
            cargarTurnosPorFecha(fecha);
        }catch(Exception e){
            LoginController.showErrorAlert("Fecha invalida");
        }finally {
            filtrarTurnosMedicoField.setText("");
        }
    }

    void cargarTurnosPorFecha(LocalDate fecha){
        Autenticable usuarioLogueado = SessionManager.getInstance().getEntidadLogueada();
        turnosMedico = FXCollections.observableArrayList();
        Optional<Medico> medico = MedicoService.getInstance().buscarMedicoPorNombreUsuario(usuarioLogueado.getNombreUsuario());

        List<Turno> listaTurnos = TurnoService.getInstance().buscarTurnosPorMedico(medico.get());

        int flag = 0;
        List<TurnoTablaMedico> listaTurnosTabla = new ArrayList<>();
        for(Turno turno : listaTurnos){
            if(turno.getPaciente() != null && fecha.isEqual(turno.getDia())) {
                TurnoTablaMedico turnoTablaMedico = new TurnoTablaMedico(turno.getDia(), turno.getHora(), turno.getPaciente());
                listaTurnosTabla.add(turnoTablaMedico);
                tablaTurnoMedicoColumnaFecha.setCellValueFactory(new PropertyValueFactory("dia"));
                tablaMedicoColumnaHora.setCellValueFactory(new PropertyValueFactory("hora"));
                tablaMedicoColumnaPaciente.setCellValueFactory(new PropertyValueFactory("paciente"));
                flag = 1;
                tablaTurnosMedico.setItems(FXCollections.observableArrayList(listaTurnosTabla));
            }
        }
        if(flag == 0){
            tablaTurnosMedico.setItems(null);
        }
    }

    @FXML
    void turnosPorPaciente() {
        String input = filtrarTurnosMedicoField.getText();
        String [] palabras = input.split(" ");
        String nombrePaciente = palabras[0];
        StringBuilder apellidoPacienteBuilder = new StringBuilder();
        for (int i = 1; i < palabras.length; i++) {
            if (i > 1) {
                apellidoPacienteBuilder.append(" ");  // Agregar espacio entre las palabras
            }
            apellidoPacienteBuilder.append(palabras[i]);
        }
        String apellidoPaciente = apellidoPacienteBuilder.toString();
        Paciente paciente = PacienteService.getInstance().buscarPacientePorNombreYApellido(nombrePaciente, apellidoPaciente);
        try{
            cargarTurnosPorPaciente(paciente);
        }catch (Exception e){
            LoginController.showErrorAlert("El paciente no existe");
        }finally {
            filtrarTurnosMedicoField.setText("");
        }

    }

    void cargarTurnosPorPaciente(Paciente paciente){
        Autenticable usuarioLogueado = SessionManager.getInstance().getEntidadLogueada();
        turnosMedico = FXCollections.observableArrayList();
        Optional<Medico> medico = MedicoService.getInstance().buscarMedicoPorNombreUsuario(usuarioLogueado.getNombreUsuario());

        List<Turno> listaTurnos = TurnoService.getInstance().buscarTurnosPorMedico(medico.get());

        List<TurnoTablaMedico> listaTurnosTabla = new ArrayList<>();
        for(Turno turno : listaTurnos){
            if(turno.getPaciente() != null && paciente.equals(turno.getPaciente())) {
                TurnoTablaMedico turnoTablaMedico = new TurnoTablaMedico(turno.getDia(), turno.getHora(), turno.getPaciente());
                listaTurnosTabla.add(turnoTablaMedico);
                tablaTurnoMedicoColumnaFecha.setCellValueFactory(new PropertyValueFactory("dia"));
                tablaMedicoColumnaHora.setCellValueFactory(new PropertyValueFactory("hora"));
                tablaMedicoColumnaPaciente.setCellValueFactory(new PropertyValueFactory("paciente"));

                tablaTurnosMedico.setItems(FXCollections.observableArrayList(listaTurnosTabla));
            }
        }

    }

    @FXML
    void clickSeleccionPacienteVerTurnosDoctor (MouseEvent event){
        buscarTurnosDoctorPanel.setVisible(false);

        pacienteVerTurnosDoctorPanel.setVisible(true);
        obtenerPacienteDesdeTurno();
    }

    private void obtenerPacienteDesdeTurno (){
        //cargar labels de pacienteVerTurnosDoctorPanel con los datos del paciente seleccionado en una fila de la tabla
        Autenticable usuarioLogueado = SessionManager.getInstance().getEntidadLogueada();
        TurnoTablaMedico tablaTurno = tablaTurnosMedico.getSelectionModel().getSelectedItem();
        LocalDate fecha = LocalDate.parse(tablaTurno.getDia());
        LocalTime hora = LocalTime.parse(tablaTurno.getHora());

        Turno turno = TurnoService.getInstance().buscarTurnoPorMedicoDiaYHora(((Medico) usuarioLogueado), fecha, hora);

        if (turno != null){
            Paciente paciente = turno.getPaciente();
            cargarLabelsPacienteVerTurno(paciente);
        }

    }

    private void cargarLabelsPacienteVerTurno (Paciente paciente){
        userPacienteVerTurnoLabel.setText(paciente.getNombreUsuario());
        nombrePacienteVerTurnoLabel.setText(paciente.getNombre());
        apellidoPacienteVerTurnoLabel.setText(paciente.getApellido());
        obraSocialPacienteVerTurnoLabel.setText(paciente.getObraSocial());
        nroAfiliadoPacienteVerTurnoLabel.setText(paciente.getNumeroAfiliado());
    }

    @FXML
    void limpiarFiltrosTurnos(ActionEvent event){
        cargarTablaMedico();
    }


    @FXML
    void clickClosePatienteViewAppointment (ActionEvent event){
        pacienteVerTurnosDoctorPanel.setVisible(false);

        buscarTurnosDoctorPanel.setVisible(true);
    }

    @FXML
    void logoutMedico(MouseEvent event) {
        SessionManager.getInstance().cerrarSesion();
        //volver a la vista principal
        LoginController.mostrarLogin();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setMainController(LoginController loginController) {
        this.loginController = loginController;
    }

}


