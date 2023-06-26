package com.example.tpfinallab3.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;
import java.time.LocalTime;

public class TurnoTabla {
    private final StringProperty dia;
    private final StringProperty hora;
    private final StringProperty especialidad;
    private final StringProperty medico;
    private final StringProperty paciente;
    private final StringProperty obraSocial;

    public TurnoTabla(LocalDate dia, LocalTime hora, Especialidad especialidad, Medico medico, Paciente paciente, String obraSocial) {
        this.dia = new SimpleStringProperty(dia.toString());
        this.hora = new SimpleStringProperty(hora.toString());
        this.especialidad = new SimpleStringProperty(especialidad.name());
        this.medico = new SimpleStringProperty(medico.getNombre() + " " + medico.getApellido());
        this.paciente = new SimpleStringProperty(paciente != null ? paciente.getNombre() + " " + paciente.getApellido() : "");
        this.obraSocial = new SimpleStringProperty(obraSocial != null ? obraSocial : "");
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

    public String getEspecialidad() {
        return especialidad.get();
    }

    public StringProperty especialidadProperty() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad.set(especialidad);
    }

    public String getMedico() {
        return medico.get();
    }

    public StringProperty medicoProperty() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico.set(medico);
    }

    public String getPaciente() {
        return paciente.get();
    }

    public StringProperty pacienteProperty() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente.set(paciente != null ? paciente.getNombre() + " " + paciente.getApellido() : "");
    }
}
