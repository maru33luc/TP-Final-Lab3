package com.example.tpfinallab3.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ClinicController {

    @FXML
    private Button appointmentButton;

    @FXML
    private Button patientButton;

    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void initialize() {
        // Aquí puedes realizar la inicialización de la vista de la clínica
        // Configurar botones, cargar datos, etc.
    }

    @FXML
    private void handleAppointmentButton() {
        // Lógica para manejar el evento del botón de citas
        // Puedes abrir una nueva vista de citas, por ejemplo
        // mainController.showAppointmentView();
    }

    @FXML
    private void handlePatientButton() {
        // Lógica para manejar el evento del botón de pacientes
        // Puedes abrir una nueva vista de pacientes, por ejemplo
        // mainController.showPatientView();
    }
}
