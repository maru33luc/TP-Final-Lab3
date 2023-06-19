package com.example.tpfinallab3.services;

import com.example.tpfinallab3.models.Paciente;
import com.example.tpfinallab3.security.Autenticable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PacienteService {
    private static PacienteService instance;

    private static final String RUTA_JSON = "src/main/resources/json/pacientes.json";

    private List<Paciente> pacientes;

    private PacienteService() {
        pacientes = new ArrayList<>();
    }

    public static PacienteService getInstance() {
        if (instance == null) {
            synchronized (PacienteService.class) {
                if (instance == null) {
                    instance = new PacienteService();
                    instance.setPacientes();
                }
            }
        }
        return instance;
    }

    public void setPacientes() {
        try{
            List<Paciente> listaPacientes = JsonService.getInstance().leerJson(RUTA_JSON, Paciente.class);
            pacientes.addAll(listaPacientes);
        }catch (Exception e){
            System.out.println("No se pudo leer el archivo json");
        }
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

    public boolean existePaciente(String nombreUsuario) {
        return pacientes.stream()
                .anyMatch(paciente -> paciente.getNombreUsuario().equalsIgnoreCase(nombreUsuario));
    }

    public Autenticable getNombreUsuario(String nombreUsuario) {
        return pacientes.stream()
                .filter(paciente -> paciente.getNombreUsuario().equalsIgnoreCase(nombreUsuario))
                .findFirst()
                .orElse(null);
    }

    public void guardarPacientesJson() {
        JsonService.getInstance().guardarJson(pacientes, RUTA_JSON);
    }

}

