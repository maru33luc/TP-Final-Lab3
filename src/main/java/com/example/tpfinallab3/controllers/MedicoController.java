package com.example.tpfinallab3.controllers;

import com.example.tpfinallab3.models.Autenticable;
import com.example.tpfinallab3.models.Especialidad;
import com.example.tpfinallab3.models.Medico;
import com.example.tpfinallab3.models.Turno;
import com.example.tpfinallab3.security.SessionManager;
import com.example.tpfinallab3.services.MedicoService;
import com.example.tpfinallab3.services.TurnoService;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    private TableView<Turno> tablaTurnosMedico;

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

        turnosMedico = FXCollections.observableArrayList();
        Optional<Medico> medic = MedicoService.getInstance().buscarMedicoPorNombreUsuario(usuarioLogueado.getNombreUsuario());
        System.out.println(usuarioLogueado.toString());

        List<Turno> listaTurnos = TurnoService.getInstance().buscarTurnosPorMedico(medic.get());

        tablaTurnoMedicoColumnaFecha.setCellValueFactory(new PropertyValueFactory("fecha"));
        tablaMedicoColumnaHora.setCellValueFactory(new PropertyValueFactory("hora"));
        tablaMedicoColumnaPaciente.setCellValueFactory(new PropertyValueFactory("paciente"));

        tablaTurnosMedico.setItems(FXCollections.observableArrayList(listaTurnos));
    }

    @FXML
    private void verPerfilMedico(MouseEvent event) {
        myProfileDataMedicoPanel.setVisible(true);
        turnosViewMedicoPanel.setVisible(false);
    }

    @FXML
    private void verTurnosMedico(MouseEvent event) {
        myProfileDataMedicoPanel.setVisible(false);
        turnosViewMedicoPanel.setVisible(true);
        verTodosLosTurnosMedico();
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
    void verTodosLosTurnosMedico(){
        //muestra todos los turnos del medico logueado
    }

    @FXML
    void turnosPorFecha(ActionEvent event) {
        //filtra por fecha
    }

    @FXML
    void turnosPorPaciente(ActionEvent event) {
        //filtra por paciente
    }

    @FXML
    void cancelFiltrarPorFecha(ActionEvent event) {
        //vuelve a la vista anterior
    }

    @FXML
    void cancelFiltrarPorPaciente(ActionEvent event) {
        //vuelve a la vista anterior

    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setMainController(LoginController loginController) {
        this.loginController = loginController;
    }

}


