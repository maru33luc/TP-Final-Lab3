package com.example.tpfinallab3.services;

import com.example.tpfinallab3.models.Autenticable;
import com.example.tpfinallab3.models.Paciente;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class PacienteService {
    private static PacienteService instance;
    private static final String RUTA_JSON = "src/main/resources/json/pacientes.json";
    private Set<Paciente> pacientes;
    private PacienteService() {
        pacientes = new HashSet<>();
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
            Set<Paciente> listaPacientes = JsonService.getInstance().leerJson(RUTA_JSON, Paciente.class);
            if (listaPacientes != null)
                pacientes.addAll(listaPacientes);
    }

    public Set<Paciente> getPacientes() {
        return pacientes;
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        guardarPacientesJson();
    }

    public void modificarPaciente(String usuario, String nombre, String apellido, String mail, String telefono, String obraSocial, String numeroAfiliado) {
        pacientes.stream()
                .filter(p -> p.getNombreUsuario().equalsIgnoreCase(usuario))
                .findFirst()
                .ifPresent(p -> {
                    p.setNombre(nombre);
                    p.setApellido(apellido);
                    p.setMail(mail);
                    p.setTelefono(telefono);
                    p.setObraSocial(obraSocial);
                    p.setNumeroAfiliado(numeroAfiliado);
                });
        guardarPacientesJson();
    }

    public Optional<Paciente> buscarPacientePorNombreUsuario(String nombreUsuario) {
        return pacientes.stream()
                .filter(paciente -> paciente.getNombreUsuario().equalsIgnoreCase(nombreUsuario))
                .findFirst();
    }

    public Paciente buscarPacientePorNombreYApellido(String nombre, String apellido){
        return pacientes.stream()
                .filter(paciente -> paciente.getNombre().equalsIgnoreCase(nombre) && paciente.getApellido().equalsIgnoreCase(apellido))
                .findFirst()
                .orElse(null);
    }

    public List<Paciente> buscarPacientesPorApellido(String apellido) {
        return pacientes.stream()
                .filter(paciente -> paciente.getApellido().equalsIgnoreCase(apellido))
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

    public Paciente retornaPacientePorCampoTextField (String texto){

        String[] palabras = texto.split(" ");

        String nombrePaciente = palabras[0];
        StringBuilder apellidoPacienteBuilder = new StringBuilder();

        // Combinar las palabras del apellido en una sola cadena
        for (int i = 1; i < palabras.length; i++) {
            if (i > 1) {
                apellidoPacienteBuilder.append(" ");  // Agregar espacio entre las palabras
            }
            apellidoPacienteBuilder.append(palabras[i]);
        }

        String apellidoPacienteBuilderString = apellidoPacienteBuilder.toString();
        Paciente paciente = PacienteService.getInstance().buscarPacientePorNombreYApellido(nombrePaciente, apellidoPacienteBuilderString);
        return paciente;
    }

    public List<Paciente> buscarPacientesPorNombre(String nombre){
        return pacientes.stream()
                .filter(paciente -> paciente.getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());
    }

    public void modificarContraseñaEnPaciente(String nombreUsuario, String nuevaContraseña) {
        pacientes.stream()
                .filter(p -> p.getNombreUsuario().equalsIgnoreCase(nombreUsuario))
                .findFirst()
                .ifPresent(p -> {
                    p.setContrasena(nuevaContraseña);
                });
        guardarPacientesJson();
    }
}