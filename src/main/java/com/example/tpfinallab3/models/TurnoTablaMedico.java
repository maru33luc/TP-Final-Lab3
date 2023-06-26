package com.example.tpfinallab3.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;
import java.time.LocalTime;

public class TurnoTablaMedico {
    private final StringProperty dia;
    private final StringProperty hora;
    private final StringProperty paciente;

    public TurnoTablaMedico(LocalDate dia, LocalTime hora, Paciente paciente) {
        this.dia = new SimpleStringProperty(dia.toString());
        this.hora= new SimpleStringProperty(hora.toString());
        this.paciente = new SimpleStringProperty(paciente.getNombre() + " " + paciente.getApellido());
    }

    public String getDia() {
        return dia.get();
    }

    public StringProperty diaProperty() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia.set(String.valueOf(dia));
    }

    public String getHora() {
        return hora.get();
    }

    public StringProperty horaProperty() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora.set(String.valueOf(hora));
    }

    public StringProperty pacienteProperty() {
        return paciente;
    }

    public String getPaciente() {
        return paciente.get();
    }

    public void setPaciente(String paciente) {
        this.paciente.set(paciente);
    }
}
