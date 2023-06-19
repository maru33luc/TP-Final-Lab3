package com.example.tpfinallab3.security;

import com.example.tpfinallab3.services.PacienteService;

public class SessionManager {
    private static SessionManager instance;
    private Autenticable usuarioLogueado;

    private SessionManager() {
        // Constructor privado para seguir el patrón Singleton
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public boolean iniciarSesion(String nombreUsuario, String contrasena) {
        // Lógica para autenticar al usuario y verificar las credenciales
        // Si las credenciales son válidas, asignar el usuario logueado
        // y devolver true, de lo contrario, devolver false

        //if (AuthenticationService.getInstance().autenticarUsuario(nombreUsuario, contrasena)) {
        if (AuthenticationService.getInstance().autenticarUsuario(nombreUsuario, contrasena)) {
            // recuperar el Usuario del json de Pacientes
            PacienteService pacienteService = PacienteService.getInstance();
            if(pacienteService.existePaciente(nombreUsuario)){
                usuarioLogueado = pacienteService.getNombreUsuario(nombreUsuario);
                return true;
            }

        }
        return false;
    }

    public void cerrarSesion() {
        // Lógica para cerrar la sesión del usuario
        usuarioLogueado = null;
    }

    public boolean isUsuarioLogueado() {
        return usuarioLogueado != null;
    }

    public Autenticable getUsuarioLogueado() {
        return usuarioLogueado;
    }
}
