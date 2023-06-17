package com.example.tpfinallab3.services;

import com.example.tpfinallab3.entities.Especialidad;
import com.example.tpfinallab3.entities.Medico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MedicoService {
    private List<Medico> medicos;

    public MedicoService() {
        medicos = new ArrayList<>();
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
    public Optional<Medico> buscarMedicoPorMatricula(Integer matricula) {
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
    }

    // Otros métodos de búsqueda y operaciones relacionadas con los médicos
}
