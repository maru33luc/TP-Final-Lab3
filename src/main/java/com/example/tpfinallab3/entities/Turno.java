package com.example.tpfinallab3.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Turno {
    private Integer id;
    private LocalDate fecha;
    private LocalTime hora;
    private Paciente paciente;
    private Medico medico;
    private Boolean isDisponible;

      public Turno() {
    }

    public Turno(Integer id, Integer ano, Integer mes, Integer dia, Integer hora, Integer minuto, Paciente paciente, Medico medico) {
        this.id = id;
        this.fecha = LocalDate.of(ano, mes, dia);
        this.hora = LocalTime.of(hora, minuto);
        this.paciente = paciente;
        this.medico = medico;
        this.isDisponible = true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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
        return this.getFecha().isEqual(turno.getFecha()) && this.getPaciente().equals(turno.getPaciente()) && this.getMedico().equals(turno.getMedico());
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha, paciente, medico);
    }

    @Override
    public String toString() {
        return "TURNO\n" +
                "ID: " + id + "\n" +
                "Fecha: " + fecha + "\n" +
                "Hora: " + hora + "\n" +
                "Paciente: " + paciente.getApellido() + " " + paciente.getNombre() + "\n" +
                "Medico: " + medico.getApellido() + " " + medico.getNombre() + "\n" +
                "Disponible: " + (isDisponible? "si" : "no");
    }
}
