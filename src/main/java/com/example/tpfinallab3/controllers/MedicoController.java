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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.time.LocalDate;
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
    private ImageView closeWindowMedicoView;

    @FXML
    private Label emailMedicoLabel;

    @FXML
    private Label especialidadMedicoLabel;

    @FXML
    private Button filtrarFechaTurnoMedicoButton;

    @FXML
    private Button filtrarPacienteTurnoMedicoButton;

    @FXML
    private ImageView minimizeMedicoViewButton;

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
    private AnchorPane filtrarFechaPanel;

    @FXML
    private AnchorPane filtrarPacientePanel;

    @FXML
    private TextField filtrarFechaField;

    @FXML
    private Button filtrarFechaAcceptButton;

    @FXML
    private Button filtrarFechaCancelButton;

    @FXML
    private TextField filtrarPacienteField;
    @FXML
    private Button filtrarPacienteAcceptButton;

    @FXML
    private Button filtrarPacienteCancelButton;
    @FXML
    private Label logoutMedicoButton;

    private ObservableList<Turno> turnosMedico;


    @FXML
    public void initialize(){
        Autenticable usuarioLogueado= SessionManager.getInstance().getEntidadLogueada();
        try{
            nombreMedicoLabel.setText(usuarioLogueado.getNombre());
            apellidoMedicoLabel.setText(usuarioLogueado.getApellido());
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

                tablaTurnosMedico.setItems(FXCollections.observableArrayList(listaTurnosTabla));
            }
        }
    }
    @FXML
    private void verPerfilMedico(MouseEvent event) {
        myProfileDataMedicoPanel.setVisible(true);
        turnosViewMedicoPanel.setVisible(false);
    }

    @FXML
    private void verTurnosMedico(MouseEvent event) {
        cargarTablaMedico();
        myProfileDataMedicoPanel.setVisible(false);
        turnosViewMedicoPanel.setVisible(true);
    }

    @FXML
    private void buscarTurnosPorFechaMedico(ActionEvent event) {
        filtrarPacientePanel.setVisible(false);
        filtrarFechaPanel.setVisible(true);
    }

    @FXML
    private void buscarTurnosPorPacienteMedico(ActionEvent event) {
        filtrarFechaPanel.setVisible(false);
        filtrarPacientePanel.setVisible(true);
    }

    @FXML
    void turnosPorFecha(ActionEvent event) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try{
            LocalDate fecha = LocalDate.parse(filtrarFechaField.getText(), dateFormatter);
            cargarTurnosPorFecha(fecha);
            filtrarFechaPanel.setVisible(false);
            filtrarFechaField.setText("");
        }catch(Exception e){
            LoginController.showErrorAlert("Fecha invalida");
            filtrarFechaField.setText("");
        }
    }

    void cargarTurnosPorFecha(LocalDate fecha){
        Autenticable usuarioLogueado = SessionManager.getInstance().getEntidadLogueada();
        turnosMedico = FXCollections.observableArrayList();
        Optional<Medico> medico = MedicoService.getInstance().buscarMedicoPorNombreUsuario(usuarioLogueado.getNombreUsuario());
        System.out.println(usuarioLogueado.toString());
        List<Turno> listaTurnos = TurnoService.getInstance().buscarTurnosPorMedico(medico.get());

        List<TurnoTablaMedico> listaTurnosTabla = new ArrayList<>();
        for(Turno turno : listaTurnos){
            if(turno.getPaciente() != null && fecha.isEqual(turno.getDia())) {
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
    void turnosPorPaciente(ActionEvent event) {
        Optional<Paciente> paciente = PacienteService.getInstance().buscarPacientePorNombreUsuario(filtrarPacienteField.getText());
        try{
            cargarTurnosPorPaciente(paciente.get());
            filtrarPacientePanel.setVisible(false);
            filtrarPacienteField.setText("");
        }catch (Exception e){
            LoginController.showErrorAlert("El paciente no existe");
            filtrarPacienteField.setText("");
        }

    }

    void cargarTurnosPorPaciente(Paciente paciente){
        Autenticable usuarioLogueado = SessionManager.getInstance().getEntidadLogueada();
        turnosMedico = FXCollections.observableArrayList();
        Optional<Medico> medico = MedicoService.getInstance().buscarMedicoPorNombreUsuario(usuarioLogueado.getNombreUsuario());
        System.out.println(usuarioLogueado.toString());
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
    void cancelFiltrarPorFecha(ActionEvent event) {
        filtrarFechaPanel.setVisible(false);
    }

    @FXML
    void cancelFiltrarPorPaciente(ActionEvent event) {
        filtrarPacientePanel.setVisible(false);

    }

    @FXML
    void logoutMedico(MouseEvent event) {
        SessionManager.getInstance().cerrarSesion();
        ///volver a la vista del login
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setMainController(LoginController loginController) {
        this.loginController = loginController;
    }

}


