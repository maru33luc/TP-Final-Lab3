package com.example.tpfinallab3.controllers;

import com.example.tpfinallab3.models.Autenticable;
import com.example.tpfinallab3.models.Medico;
import com.example.tpfinallab3.models.Turno;
import com.example.tpfinallab3.security.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MedicoViewController {

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
    private TableColumn<Turno, String> tablaMedicoColumnaHora;

    @FXML
    private TableColumn<Turno, String> tablaMedicoColumnaPaciente;

    @FXML
    private TableColumn<Turno, String> tablaTurnoMedicoColumnaFecha;

    @FXML
    private TableView<Turno> tablaTurnosMedico;

    @FXML
    private AnchorPane turnosViewMedicoPanel;

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
        //filtrar por fecha
    }

    @FXML
    private void buscarTurnosPorPacienteMedico(ActionEvent event) {
        ///filtrar por paciente
    }

    @FXML
    void verTodosLosTurnosMedico(){
        //muestra todos los turnos del medico logueado
    }
}


