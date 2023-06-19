package com.example.tpfinallab3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PruebaController {
    @FXML
    private Button buttonPrueba;

    @FXML
    private void click(ActionEvent event) {
        // Lógica para manejar el evento de clic en el botón
        System.out.println("¡Se hizo clic en el botón!");
    }
}
