package com.example.tpfinallab3.services;

import com.example.tpfinallab3.models.Medico;
import com.example.tpfinallab3.models.Paciente;
import com.example.tpfinallab3.models.Turno;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TurnoService {
    private static TurnoService instance;
    private List<Turno> turnos;

    private TurnoService() {
        turnos = new ArrayList<>();
    }

    public static TurnoService getInstance() {
        if (instance == null) {
            synchronized (TurnoService.class) {
                if (instance == null) {
                    instance = new TurnoService();
                }
            }
        }
        return instance;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void agregarTurno(Turno turno) {
        turnos.add(turno);
    }

    public void eliminarTurno(Turno turno) {
        turnos.remove(turno);
    }

    public Optional<Turno> buscarTurnoPorId(Integer id) {
        return turnos.stream()
                .filter(turno -> turno.getId().equals(id))
                .findFirst();
    }

    public void actualizarTurno(Turno turno) {
        Optional<Turno> turnoEncontrado = buscarTurnoPorId(turno.getId());
        if (turnoEncontrado.isPresent()) {
            eliminarTurno(turnoEncontrado.get());
            agregarTurno(turno);
        }
    }

    public List<Turno> buscarTurnosPorFecha(LocalDate fecha) {
        return turnos.stream()
                .filter(turno -> turno.getFecha().equals(fecha))
                .collect(Collectors.toList());
    }

    public List<Turno> buscarTurnosPorMedico(Medico medico) {
        return turnos.stream()
                .filter(turno -> turno.getMedico().equals(medico))
                .collect(Collectors.toList());
    }

    public List<Turno> buscarTurnosPorPaciente(Paciente paciente) {
        return turnos.stream()
                .filter(turno -> turno.getPaciente().equals(paciente))
                .collect(Collectors.toList());
    }

    public List<Turno> buscarTurnosDisponibles() {
        return turnos.stream()
                .filter(Turno::getDisponible)
                .collect(Collectors.toList());
    }

    public void marcarTurnoComoOcupado(Turno turno) {
        turno.setDisponible(false);
    }

    public void marcarTurnoComoDisponible(Turno turno) {
        turno.setDisponible(true);
    }

    // Otros métodos de búsqueda y operaciones relacionadas con los turnos

    public List<Turno> buscarTurnosEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return turnos.stream()
                .filter(turno -> turno.getFecha().isAfter(fechaInicio) && turno.getFecha().isBefore(fechaFin))
                .collect(Collectors.toList());
    }

    public boolean validarDisponibilidadTurno(Turno turno) {
        return turnos.stream()
                .anyMatch(t -> t.getFecha().equals(turno.getFecha()) && t.getHora().equals(turno.getHora()) && !t.getDisponible());
    }
}
