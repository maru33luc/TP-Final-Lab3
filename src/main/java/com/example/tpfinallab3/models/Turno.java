package com.example.tpfinallab3.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Turno implements Serializable {

    private LocalDate dia;
    private LocalTime hora;
    private Paciente paciente;
    private Medico medico;
    private Boolean isDisponible;

    public Turno() {
    }

    public Turno(LocalDate dia, LocalTime hora, Medico medico) {
        this.dia = dia;
        this.hora = hora;
        this.paciente = null;
        this.medico = medico;
        this.isDisponible = true;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate fecha) {
        this.dia = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Boolean getDisponible() {
        return isDisponible;
    }

    public void setDisponible(Boolean disponible) {
        isDisponible = disponible;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Turno other = (Turno) obj;
        // Compare dia, hora y medico
        return getDia().equals(other.getDia()) &&
                getHora().equals(other.getHora()) &&
                getMedico().equals(other.getMedico());
    }

    @Override
    public int hashCode() {
        return Objects.hash(dia, paciente, medico);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Turno: ").append("Dia: ").append(dia).append(", Hora: ").append(hora);
        sb.append(" Medico: ").append(medico.getNombre()).append(" ").append(medico.getApellido());
        if (paciente != null) {
            sb.append(", Paciente: ").append(paciente.getApellido()).append(", Médico: ").append(medico.getApellido());
        }
        return sb.toString();
    }
}
