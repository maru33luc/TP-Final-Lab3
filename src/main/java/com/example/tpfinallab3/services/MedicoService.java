package com.example.tpfinallab3.services;

import com.example.tpfinallab3.models.Especialidad;
import com.example.tpfinallab3.models.Medico;
import com.example.tpfinallab3.security.AuthorizationService;
import com.example.tpfinallab3.security.SessionManager;

import java.util.*;
import java.util.stream.Collectors;

public class MedicoService {
    private static MedicoService instance;
    private static final String RUTA_JSON = "src/main/resources/json/medicos.json";
    private Set<Medico> medicos;

    private MedicoService() {
        medicos = new HashSet<>();
    }

    public static MedicoService getInstance() {
        if (instance == null) {
            synchronized (MedicoService.class) {
                if (instance == null) {
                    instance = new MedicoService();
                    instance.setMedicos();
                }
            }
        }
        return instance;
    }

    public void setMedicos() {
        Set<Medico> listaMedicos = JsonService.getInstance().leerJson(RUTA_JSON, Medico.class);
        if (listaMedicos != null)
            medicos.addAll(listaMedicos);
    }

    public Set<Medico> getMedicos() {
        return medicos;
    }

    public void agregarMedico(Medico medico) {
        if(AuthorizationService.getInstance().verificarPermiso(SessionManager.getInstance().getTipoEntidad(), "agregarMedico")){
            medicos.add(medico);
            guardarMedicosJson();
            System.out.println("Medico agregado correctamente");
        }
        else {
            System.out.println("No tiene permisos para agregar un medico");
        }
    }

    public Optional<Medico> buscarMedicoPorNombreUsuario(String nombreUsuario) {
        return medicos.stream()
                .filter(medico -> medico.getNombreUsuario().equalsIgnoreCase(nombreUsuario))
                .findFirst();
    }

    public boolean existeMedico (String nombreUsuario) {
        return buscarMedicoPorNombreUsuario(nombreUsuario).isPresent();
    }

    public List<Medico> buscarMedicosPorEspecialidad(Especialidad especialidad) {
        return medicos.stream()
                .filter(medico -> medico.getEspecialidad().equals(especialidad))
                .collect(Collectors.toList());
    }

    public void guardarMedicosJson() {
        JsonService.getInstance().guardarJson(medicos, RUTA_JSON);
    }

    public Medico buscarMedicoPorNombreYApellido(String nombreMedico, String apellidoMedico) {
        return medicos.stream()
                .filter(medico -> medico.getNombre().equalsIgnoreCase(nombreMedico) && medico.getApellido().equalsIgnoreCase(apellidoMedico))
                .findFirst()
                .orElse(null);
    }

    public void darDeBajaMedico(Medico medico) {
        if(AuthorizationService.getInstance().verificarPermiso(SessionManager.getInstance().getTipoEntidad(), "darDeBajaMedico")){
            Medico medico1= buscarMedicoPorNombreYApellido(medico.getNombre(), medico.getApellido());
            medico1.setActivo(false);
            // buscar en sus turnos y eliminarlos
            TurnoService.getInstance().eliminarTurnosDeMedico(medico1);
            System.out.println("Medico dado de baja correctamente");
            guardarMedicosJson();
        }
        else {
            System.out.println("No tiene permisos para dar de baja un medico");
        }
    }

    public void darDeAltaMedico(Medico medico) {
        if(AuthorizationService.getInstance().verificarPermiso(SessionManager.getInstance().getTipoEntidad(), "darDeAltaMedico")){
            Medico medico1= buscarMedicoPorNombreYApellido(medico.getNombre(), medico.getApellido());
            medico1.setActivo(true);
            System.out.println("Medico dado de alta correctamente");
            guardarMedicosJson();
        }
        else {
            System.out.println("No tiene permisos para dar de alta un medico");
        }
    }

    public boolean chequearEstadoMedico(Medico medico) {
        return medicos.stream()
                .filter(medico1 -> medico1.getNombre().equalsIgnoreCase(medico.getNombre()) && medico1.getApellido().equalsIgnoreCase(medico.getApellido()))
                .findFirst()
                .get().getActivo();
    }

    public Set<Medico> getMedicosActivos() {
        Set<Medico> medicosActivos = new HashSet<>();
        for (Medico medico : medicos) {
            if (medico.getActivo()) {
                medicosActivos.add(medico);
            }
        }
        return medicosActivos;
    }

    public Medico retornaMedicoPorCampoTextField (String texto){

        String[] palabras = texto.split(" ");

        String nombreMedico = palabras[0];
        StringBuilder apellidoMedicoBuilder = new StringBuilder();

        //Combina las palabras del apellido en una sola cadena
        for (int i = 1; i < palabras.length; i++) {
            if (i > 1) {
                apellidoMedicoBuilder.append(" ");//Agrega espacio entre las palabras
            }
            apellidoMedicoBuilder.append(palabras[i]);
        }

        String apellidoMedico = apellidoMedicoBuilder.toString();
        Medico medico = MedicoService.getInstance().buscarMedicoPorNombreYApellido(nombreMedico, apellidoMedico);
        return medico;
    }

    public void modificarContraseñaEnMedico(String nombreUsuario, String nuevaContraseña) {
        Optional<Medico> medico = buscarMedicoPorNombreUsuario(nombreUsuario);
        if (medico.isPresent()) {
            medico.get().setContrasena(nuevaContraseña);
            guardarMedicosJson();
        }
    }

    public void modificarMedico(String usuario, String nombre, String apellido, String mail, Especialidad especialidad) {
        medicos.stream()
                .filter(a -> a.getNombreUsuario().equalsIgnoreCase(usuario))
                .findFirst()
                .ifPresent(a -> {
                    a.setNombre(nombre);
                    a.setApellido(apellido);
                    a.setMail(mail);
                    a.setEspecialidad(especialidad);
                });
        guardarMedicosJson();
    }
}
