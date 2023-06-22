package com.example.tpfinallab3.security;

import com.example.tpfinallab3.models.Administrativo;
import com.example.tpfinallab3.models.Autenticable;
import com.example.tpfinallab3.models.Medico;
import com.example.tpfinallab3.models.Paciente;
import com.example.tpfinallab3.services.AdministrativoService;
import com.example.tpfinallab3.services.MedicoService;
import com.example.tpfinallab3.services.PacienteService;

import java.util.Optional;

public class SessionManager {
    private static SessionManager instance;
    private Autenticable entidadLogueada;
    private String tipoEntidad;

    private SessionManager() {
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public boolean iniciarSesion(String nombreUsuario, String contrasena) {
        if (AuthenticationService.getInstance().autenticarUsuario(nombreUsuario, contrasena)) {

            PacienteService pacienteService = PacienteService.getInstance();
            MedicoService medicoService = MedicoService.getInstance();
            AdministrativoService administrativoService = AdministrativoService.getInstance();
            if (pacienteService.existePaciente(nombreUsuario)) {
                Optional <Paciente> pacienteOptional = pacienteService.buscarPacientePorNombreUsuario(nombreUsuario);
                entidadLogueada = pacienteOptional.map(paciente -> (Autenticable) paciente).orElse(null);
                tipoEntidad = "paciente";
                return true;
            } else if (medicoService.existeMedico(nombreUsuario)) {
                Optional <Medico> medicoOptional = medicoService.buscarMedicoPorNombreUsuario(nombreUsuario);
                entidadLogueada = medicoOptional.map(medico -> (Autenticable) medico).orElse(null);
                tipoEntidad = "medico";
                return true;
            } else if (administrativoService.existeAdministrativoPorNombreUsuario(nombreUsuario)) {
                Optional <Administrativo> administrativoOptional = administrativoService.buscarAdministrativoPorNombreUsuario(nombreUsuario);
                entidadLogueada = administrativoOptional.map(administrativo -> (Autenticable) administrativo).orElse(null);
                tipoEntidad = "administrativo";
                return true;
            }
        }
        return false;
    }

    public void cerrarSesion() {
        // Lógica para cerrar la sesión del usuario
        this.entidadLogueada = null;
        this.tipoEntidad = null;
    }

    public boolean isUsuarioLogueado() {
        return this.entidadLogueada != null;
    }

    public Autenticable getEntidadLogueada() {
        return this.entidadLogueada;
    }

    public String getTipoEntidad() {
        return this.tipoEntidad;
    }
}
