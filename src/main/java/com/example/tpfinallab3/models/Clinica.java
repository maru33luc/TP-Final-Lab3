package com.example.tpfinallab3.models;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Clinica {
    private List<Medico> medicos=new ArrayList<>();
    private List<Paciente> pacientes=new ArrayList<>();
    private List<Administrativo> administrativos=new ArrayList<>();
    private List<Turno> turnos=new ArrayList<>();

    public Clinica (){

    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<Administrativo> getAdministrativos() {
        return administrativos;
    }

    public void setAdministrativos(List<Administrativo> administrativos) {
        this.administrativos = administrativos;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public void validarMedico(Medico nuevo) throws InputMismatchException {
        for (Medico medico : medicos) {
            if (medico.getNombreUsuario().equals(nuevo.getNombreUsuario())) {
                throw new InputMismatchException("El nombre de usuario ya existe");
            }
        }
        if (nuevo.getNombreUsuario().isEmpty()) {
            throw new InputMismatchException("Nombre de usuario obligatorio");
        }
        if (nuevo.getContrasena().length() < 6) {
            throw new InputMismatchException("La contraseña debe tener al menos 6 caracteres");
        }
        if (nuevo.getNombre().isEmpty()) {
            throw new InputMismatchException("Nombre obligatorio");
        }
        if (nuevo.getApellido().isEmpty()) {
            throw new InputMismatchException("Apellido obligatorio");
        }
        if (nuevo.getEspecialidad().toString().isEmpty()) {
            throw new InputMismatchException("Especialidad obligatoria");
        }
    }

    public void validarPaciente(Paciente nuevo) throws InputMismatchException {
        for (Paciente paciente : pacientes) {
            if (paciente.getNombreUsuario().equals(nuevo.getNombreUsuario())) {
                throw new InputMismatchException("El nombre de usuario ya existe");
            }
        }
        if (nuevo.getNombreUsuario().isEmpty()) {
            throw new InputMismatchException("Nombre de usuario obligatorio");
        }
        if (nuevo.getContrasena().length() < 6) {
            throw new InputMismatchException("La contraseña debe tener al menos 6 caracteres");
        }
        if (nuevo.getNombre().isEmpty()) {
            throw new InputMismatchException("Nombre obligatorio");
        }
        if (nuevo.getApellido().isEmpty()) {
            throw new InputMismatchException("Apellido obligatorio");
        }
    }

    public void validarAdministrativo(Administrativo nuevo) throws InputMismatchException {
        for (Administrativo administrativo : administrativos) {
            if (administrativo.getNombreUsuario().equals(nuevo.getNombreUsuario())) {
                throw new InputMismatchException("El nombre de usuario ya existe");
            }
        }
        if (nuevo.getNombreUsuario().isEmpty()) {
            throw new InputMismatchException("Nombre de usuario obligatorio");
        }
        if (nuevo.getContrasena().length() < 6) {
            throw new InputMismatchException("La contraseña debe tener al menos 6 caracteres");
        }
        if (nuevo.getNombre().isEmpty()) {
            throw new InputMismatchException("Nombre obligatorio");
        }
        if (nuevo.getApellido().isEmpty()) {
            throw new InputMismatchException("Apellido obligatorio");
        }
    }


    //--------- JSON ---------
    public static <T> void guardarJson(List<T> lista, String ruta) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            objectMapper.writeValue(new File(ruta), lista);
            System.out.println("Json guardado");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> leerJson(String ruta, Class<T> clase) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, clase);
        try {
            return objectMapper.readValue(new File(ruta), javaType);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
