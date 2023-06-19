package com.example.tpfinallab3.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Turno {
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
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null) {
            return false;
        }
        if(!(o instanceof Turno)) {
            return false;
        }
        Turno turno = (Turno) o;
        return this.getDia().isEqual(turno.getDia()) && this.getPaciente().equals(turno.getPaciente()) && this.getMedico().equals(turno.getMedico());
    }

    @Override
    public int hashCode() {
        return Objects.hash(dia, paciente, medico);
    }

    @Override
    public String toString() {
        return "TURNO\n" +
                "Día: " + dia + "\n" +
                "Hora: " + hora + "\n" +
                "Paciente: " + paciente.getApellido() + " " + paciente.getNombre() + "\n" +
                "Medico: " + medico.getApellido() + " " + medico.getNombre() + "\n" +
                "Disponible: " + (isDisponible? "si" : "no");
    }
}
