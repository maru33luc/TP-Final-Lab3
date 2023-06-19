package com.example.tpfinallab3.services;

import com.example.tpfinallab3.models.Especialidad;
import com.example.tpfinallab3.models.Medico;
import com.example.tpfinallab3.models.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MedicoService {
    private static MedicoService instance;
    private static final String RUTA_JSON = "src/main/resources/json/medicos.json";
    private List<Medico> medicos;

    private MedicoService() {
        medicos = new ArrayList<>();
    }

    public static MedicoService getInstance() {
        if (instance == null) {
            synchronized (MedicoService.class) {
                if (instance == null) {
                    instance = new MedicoService();
                }
            }
        }
        return instance;
    }

    public void setMedicos() {
        // leer la lista de pacientes del json y guardarla en la lista de pacientes
        List<Medico> listaMedicos = JsonService.getInstance().leerJson(RUTA_JSON, Medico.class);
        medicos.addAll(listaMedicos);
    }
    public List<Medico> getMedicos() {
        return medicos;
    }

    public void agregarMedico(Medico medico) {
        medicos.add(medico);
    }

    public void eliminarMedico(Medico medico) {
        medicos.remove(medico);
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

    public List<Medico> buscarMedicosPorEspecialidad(Especialidad especialidad) {
        return medicos.stream()
                .filter(medico -> medico.getEspecialidad().equals(especialidad))
                .collect(Collectors.toList());
    }

    // buscar medico por matricula
    /*public Optional<Medico> buscarMedicoPorMatricula(String matricula) {
        return medicos.stream()
                .filter(medico -> medico.getNumeroMatricula().equals(matricula))
                .findFirst();
    }*/

   /* public List<Medico> buscarMedicosDisponibles() {
        return medicos.stream()
                .filter(Medico::getDisponible)
                .collect(Collectors.toList());
    }*/

    // Otros métodos de búsqueda y operaciones relacionadas con los médicos
}
