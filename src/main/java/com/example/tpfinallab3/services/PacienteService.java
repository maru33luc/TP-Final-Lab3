package com.example.tpfinallab3.services;

import com.example.tpfinallab3.entities.Paciente;
import com.example.tpfinallab3.entities.Turno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PacienteService {
    private List<Paciente> pacientes;

    public PacienteService() {
        pacientes = new ArrayList<>();
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void eliminarPaciente(Paciente paciente) {
        pacientes.remove(paciente);
    }

    public void actualizarPaciente(Integer dni, Paciente pacienteActualizado) {
        pacientes.stream()
                .filter(paciente -> paciente.getNumeroDocumento().equals(dni))
                .findFirst()
                .ifPresent(paciente -> {
                    paciente.setNombre(pacienteActualizado.getNombre());
                    paciente.setApellido(pacienteActualizado.getApellido());
                    paciente.setObraSocial(pacienteActualizado.getObraSocial());
                    paciente.setNombreUsuario(pacienteActualizado.getNombreUsuario());
                    paciente.setContrasena(pacienteActualizado.getContrasena());
                });
    }

    public Optional<Paciente> buscarPacientePorNombreUsuario(String nombreUsuario) {
        return pacientes.stream()
                .filter(paciente -> paciente.getNombreUsuario().equalsIgnoreCase(nombreUsuario))
                .findFirst();
    }

    public List<Paciente> buscarPacientesPorObraSocial(String obraSocial) {
        return pacientes.stream()
                .filter(paciente -> paciente.getObraSocial().equalsIgnoreCase(obraSocial))
                .collect(Collectors.toList());
    }

    public List<Paciente> buscarPacientesPorApellido(String apellido) {
        return pacientes.stream()
                .filter(paciente -> paciente.getApellido().equalsIgnoreCase(apellido))
                .collect(Collectors.toList());
    }

    public List<Paciente> buscarPacientesConTurnosSacados() {
        return pacientes.stream()
                .filter(paciente -> paciente.getTurnos().size() > 0)
                .collect(Collectors.toList());
    }

    // Otros métodos de búsqueda y operaciones relacionadas con los pacientes
}
