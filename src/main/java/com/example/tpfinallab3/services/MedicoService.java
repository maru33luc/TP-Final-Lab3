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
        }else
        {
            System.out.println("No tiene permisos para agregar un medico");
        }

    }

    public void eliminarMedico(Medico medico) {
        if(AuthorizationService.getInstance().verificarPermiso(SessionManager.getInstance().getTipoEntidad(), "eliminarMedico")){
            medicos.remove(medico);
            System.out.println("Medico eliminado correctamente");
        }else
        {
            System.out.println("No tiene permisos para eliminar un medico");
        }
    }

    /*public void actualizarMedico(Medico medico) {
        Optional<Medico> medicoEncontrado = buscarMedicoPorMatricula(medico.getNumeroMatricula());
        if (medicoEncontrado.isPresent()) {
            eliminarMedico(medicoEncontrado.get());
            agregarMedico(medico);
        }

    }*/

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

    /*public Optional<Medico> buscarMedicoPorMatricula(String matricula) {
        return medicos.stream()
                .filter(medico -> medico.getNumeroMatricula().equals(matricula))
                .findFirst();
    }
    public List<Medico> buscarMedicosDisponibles() {
        return medicos.stream()
                .filter(Medico::getDisponible)
                .collect(Collectors.toList());
    }
    public void marcarMedicoComoNoDisponible(Medico medico) {
        medico.setDisponible(false);
    }

    public void marcarMedicoComoDisponible(Medico medico) {
        medico.setDisponible(true);
    }*/

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
            System.out.println("Medico dado de baja correctamente");
            guardarMedicosJson();
        }else
        {
            System.out.println("No tiene permisos para dar de baja un medico");
        }
    }

    public void darDeAltaMedico(Medico medico) {
        if(AuthorizationService.getInstance().verificarPermiso(SessionManager.getInstance().getTipoEntidad(), "darDeAltaMedico")){
            Medico medico1= buscarMedicoPorNombreYApellido(medico.getNombre(), medico.getApellido());
            medico1.setActivo(true);
            System.out.println("Medico dado de alta correctamente");
            guardarMedicosJson();
        }else
        {
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

        // Combinar las palabras del apellido en una sola cadena
        for (int i = 1; i < palabras.length; i++) {
            if (i > 1) {
                apellidoMedicoBuilder.append(" ");  // Agregar espacio entre las palabras
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
}
